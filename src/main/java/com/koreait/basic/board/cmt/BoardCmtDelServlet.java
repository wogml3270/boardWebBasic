package com.koreait.basic.board.cmt;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardCmtEntity;
import com.koreait.basic.dao.BoardCmtDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/cmt/del")
public class BoardCmtDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = Utils.getParameterInt(req, "iboard");
        int icmt = Utils.getParameterInt(req, "icmt");
        int loginUserPk = Utils.getLoginUserPk(req);

        BoardCmtEntity param = new BoardCmtEntity();
        param.setIboard(iboard);
        param.setIcmt(icmt);
        param.setWriter(loginUserPk);

        int result = BoardCmtDAO.delBoardCmt(param);
        switch(result){
            case 1:
                res.sendRedirect("/board/detail?iboard=" + iboard);
                return;
            default:
                req.getRequestDispatcher("/board/detail?nohits=1&iboard=" + iboard).forward(req, res);
                req.setAttribute("err", "글 삭제를 실패하였습니다.");
                return;
        }

    }
}