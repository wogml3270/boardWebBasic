package com.koreait.basic;

import com.koreait.basic.user.model.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Utils {
    public static void displayView(String title, String page,
           HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("title", title);
        req.setAttribute("page", page);
        disForward(req, res, "layout");
    }

    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp)
        throws ServletException, IOException{
        req.getRequestDispatcher("/WEB-INF/view/" + jsp + ".jsp").forward(req, res);
    }
    public static int parseStringToInt(String str){
        return parseStringToInt(str, 0);
    }
    public static int parseStringToInt(String str, int defVal){
        try{
            return Integer.parseInt(str);
        } catch(Exception e){}
        return defVal;
    }
    public static int getParameterInt(HttpServletRequest req, String key){
        return parseStringToInt(req.getParameter(key));
    }
    public static int getParameterInt(HttpServletRequest req, String key, int defVal){
        return parseStringToInt(req.getParameter(key), defVal);
    }
}
