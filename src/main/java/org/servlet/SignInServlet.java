package org.servlet;

import org.service.serviceimpl.UserServiceImpl;
import org.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("newName");
        String email = req.getParameter("newEmail");
        String pwd = req.getParameter("newPwd");
        String check = req.getParameter("check");
      //  System.out.println(name+":"+email+":"+pwd+":"+check+":s-->"+req.getSession().getAttribute("checkCode"));
        if (name != null && email != null && pwd != null) {
            if(check.equals(req.getSession().getAttribute("checkCode"))){
                if (new UserServiceImpl().add(new User(name, email, pwd))) {
                    req.setAttribute("message","注册成功！");
                    req.getSession().removeAttribute("checkCode");
                    resp.sendRedirect("index.jsp");
                    return;
                } else {
                    req.setAttribute("message","注册失败！");
                    req.getRequestDispatcher("login.htmls").forward(req, resp);
                    return;
                }
            }
        } else {
            req.setAttribute("message","注册失败！");
            req.getRequestDispatcher("login.html").forward(req, resp);
            return;
        }

    }
}
