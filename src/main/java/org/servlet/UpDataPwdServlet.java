package org.servlet;

import org.service.serviceimpl.UserServiceImpl;
import org.vo.QueryVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpDataPwdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String email = req.getParameter("newEmail");
        String newPwd = req.getParameter("newPwd");
        String check = req.getParameter("check1");
       // System.out.println(email+"---"+newPwd+"----"+check);
//        System.out.println(req.getSession().getAttribute("checkCode"));
        if (email != null && new UserServiceImpl().find(email)) {
            if ( newPwd != null && check != null) {
                if (check.equals(req.getSession().getAttribute("checkCode"))) {
                    if (new UserServiceImpl().upData(new QueryVo(email,newPwd))){
                        resp.getWriter().write("alert(修改成功！)");
                        req.getSession().removeAttribute("checkCode");
                        resp.sendRedirect("login.html");
                    }
                }
            }
        }

    }
}
