package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardDTO;
import com.koreait.basic.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int searchType = Utils.getParameterInt(req, "searchType", 0);
        String searchText = req.getParameter("searchText");
        int page = Utils.getParameterInt(req, "page", 1);
        int rowCtn = Utils.getParameterInt(req, "rowCnt", 5);

        BoardDTO param = new BoardDTO();
        param.setSearchText(searchText);
        param.setSearchType(searchType);
        param.setPage(page);
        param.setRowCnt(rowCtn);

        int startIdx = (param.getPage() - 1) * param.getRowCnt();
        param.setStartIdx(startIdx);

        int maxPageNum = BoardDAO.getMaxPageNum(param);


        req.setAttribute("maxPageNum", maxPageNum);
        req.setAttribute("list", BoardDAO.selBoardList(param));

        Utils.displayView("게시판", "board/list", req, res);
    }

}