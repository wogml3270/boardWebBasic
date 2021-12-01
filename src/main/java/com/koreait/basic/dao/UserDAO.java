package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.user.model.UserEntity;

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
}
