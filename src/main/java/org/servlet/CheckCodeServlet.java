package org.servlet;

import org.service.serviceimpl.UserServiceImpl;
import org.util.CheckCodeUtil;
import org.util.SendCheckCodeUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String email = req.getParameter("newEmail");
        Integer type = Integer.parseInt(req.getParameter("type"));
//        System.out.println(type);
//        System.out.println(email);
        String checkCode;
        if (email != null) {
            HttpSession hs = req.getSession();
            if (!new UserServiceImpl().find(email)) {
                checkCode = CheckCodeUtil.getCheckCode();
                hs.setMaxInactiveInterval(60 * 5);
                if (type == SendCheckCodeUtil.SIGNIN) {
                    if (SendCheckCodeUtil.sendCheckCode(checkCode, email, type)) {
                        resp.getWriter().write("发送成功！请注意接收！");
                        // System.out.println(checkCode);
                        hs.setAttribute("checkCode", checkCode);

                    } else {
                        resp.getWriter().write("发送失败！");

                    }
                }
            } else if (type == SendCheckCodeUtil.UPDATAPWD) {
                checkCode = CheckCodeUtil.getCheckCode();
                if (SendCheckCodeUtil.sendCheckCode(checkCode, email, SendCheckCodeUtil.UPDATAPWD)) {
                    resp.getWriter().write("发送成功！请注意接收！");
                    System.out.println(checkCode);
                    hs.setAttribute("checkCode", checkCode);
                    return;
                } else {
                    resp.getWriter().write("发送失败！");
                    return;
                }
            } else if (type == SendCheckCodeUtil.SIGNIN) {
                resp.getWriter().write("该邮箱已注册！");
                return;
            } else if (type == SendCheckCodeUtil.UPDATAPWD) {
                resp.getWriter().write("该邮箱已注册！");
                return;
            }
        } else {
            resp.getWriter().write("邮箱为空！");
        }
    }
}
