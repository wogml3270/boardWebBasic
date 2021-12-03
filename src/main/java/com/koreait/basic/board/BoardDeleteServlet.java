package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardEntity;
import com.koreait.basic.dao.BoardDAO;
import com.koreait.basic.user.model.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

        int iboard = Utils.getParameterInt(req, "iboard");
        int writer = Utils.getLoginUserPk(req);

        BoardEntity param = new BoardEntity();
        param.setIboard(iboard);
        param.setWriter(writer);

        // 예외 처리
        int result = BoardDAO.delBoard(param);
//        if(result == 0){
//            req.getRequestDispatcher("/board/detail").forward(req, res);
//            return;
//        }
        switch(result){
            case 1:
                res.sendRedirect("/board/list");
                return;
            default:
                req.setAttribute("err", "글 삭제를 실패하였습니다.");
                req.getRequestDispatcher("/board/detail?iboard=" + iboard).forward(req, res);
                return;
        }
    }
}