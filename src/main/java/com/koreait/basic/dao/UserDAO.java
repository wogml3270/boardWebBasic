package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.user.model.LoginResult;
import com.koreait.basic.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDAO {
    public static int join(UserEntity param){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " INSERT INTO t_user(uid, upw, nm, gender) " +
                " VALUES(?, ?, ?, ?) ";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getUid());
            ps.setString(2, param.getUpw());
            ps.setString(3, param.getNm());
            ps.setInt(4, param.getGender());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            DbUtils.close(con, ps, rs);
        }
        return 0;
    }
    public static LoginResult login(UserEntity entity) {
        int result = 0;
        UserEntity loginUser = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iuser, upw, nm, gender FROM t_user WHERE uid = ?";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getUid());
            rs = ps.executeQuery();
            if(rs.next()) {
                String dbPw = rs.getString("upw");
                if(BCrypt.checkpw(entity.getUpw(), dbPw)) { // true 비밀번호 맞음
                    result = 1;
                    loginUser = new UserEntity();
                    loginUser.setIuser(rs.getInt("iuser"));
                    loginUser.setUid(entity.getUid());
                    loginUser.setNm(rs.getString("nm"));
                    loginUser.setGender(rs.getInt("gender"));
                } else { result = 3; }
            } else { result = 2; }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return new LoginResult(result, loginUser);
    }

}
