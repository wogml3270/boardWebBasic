package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.board.model.BoardDTO;
import com.koreait.basic.board.model.BoardEntity;
import com.koreait.basic.board.model.BoardVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class BoardDAO {
    public static int insBoardWithPk(BoardEntity entity){
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO t_board(title, ctnt, writer) " +
                " VALUES (?, ?, ?) ";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getCtnt());
            ps.setInt(3, entity.getWriter());
            result = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                int iboard = rs.getInt(1);
                entity.setIboard(iboard);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con, ps, rs);
        }
        return result;
    }
    public static int insBoard(BoardEntity entity){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO t_board(title, ctnt, writer)" +
                " VALUES(?, ?, ?) ";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getCtnt());
            ps.setInt(3, entity.getWriter());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return 0;
    }
    public static List<BoardVO> selBoardList(){
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT A.iboard, A.title, A.writer, A.hit, A.rdt, B.nm as writerNm " +
                " FROM t_board A " +
                " INNER JOIN t_user B " +
                " ON A.writer = B.iuser " +
                " ORDER BY A.iboard DESC ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int iboard = rs.getInt("iboard");
                String title = rs.getString("title");
                int writer = rs.getInt("writer");
                int hit = rs.getInt("hit");
                String rdt = rs.getString("rdt");
                String writerNm = rs.getString("writerNm");
                BoardVO vo = BoardVO.builder()
                        .iboard(iboard)
                        .title(title)
                        .writer(writer)
                        .hit(hit)
                        .rdt(rdt)
                        .writerNm(writerNm)
                        .build();
                list.add(vo);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;
    }
    public static BoardVO selBoardDetail(BoardDTO param){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT A.iboard, A.title, A.ctnt, A.writer, A.hit, A.rdt, B.nm as writerNm " +
                " FROM t_board A " +
                " INNER JOIN t_user B " +
                " ON A.writer = B.iuser " +
                " WHERE A.iboard = ? ";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            rs = ps.executeQuery();
            if(rs.next()) {
                String title = rs.getString("title");
                String ctnt = rs.getString("ctnt");
                int writer = rs.getInt("writer");
                int hit = rs.getInt("hit");
                String rdt = rs.getString("rdt");
                String writerNm = rs.getString("writerNm");
                return BoardVO.builder()
                        .iboard(param.getIboard())
                        .title(title)
                        .ctnt(ctnt)
                        .writer(writer)
                        .hit(hit)
                        .rdt(rdt)
                        .writerNm(writerNm)
                        .build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DbUtils.close(con, ps, rs);
        }
        return null;
    }
    public static void updBoardHitUp(BoardDTO param){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE t_board" +
                "SET hit = hit + 1" +
                "WHERE iboard = ? ";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con, ps);
        }
    }
    public static void delBoard(BoardDTO param){

    }
}
