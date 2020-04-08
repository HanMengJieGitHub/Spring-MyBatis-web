package org.servlet;

import org.service.serviceimpl.UserServiceImpl;
import org.vo.QueryVo;
import org.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String email = req.getParameter("email") ;
        String pwd = req.getParameter("pwd") ;
//        System.out.println(email+pwd);
        QueryVo queryVo = null;
        if (pwd!=null&&email!=null){
            queryVo = new QueryVo();
            queryVo.setEmail(email);
            queryVo.setPwd(pwd);
        }
//        System.out.println(queryVo);
        User user = null;
        if(queryVo!=null){
            user = new UserServiceImpl().loginCheck(queryVo);
        }
        if (user == null) {
//            req.getRequestDispatcher("login.html").forward(req,resp);
            resp.sendRedirect("login.html");

        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
