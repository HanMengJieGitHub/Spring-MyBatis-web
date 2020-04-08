package org.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendCheckCodeUtil {
    private String addresser ;   //发件人
    private String recipient ;   //收件人
    public static final int SIGNIN = 1;
    public static final int UPDATAPWD = 2;


    public static boolean sendCheckCode(String code, String userEmail, int type) {
        boolean flag = false;
        try {
            HtmlEmail email = new HtmlEmail();
            //2、邮箱的SMTP服务器smtp.163.com，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
            email.setHostName("220.181.12.18");
            //设置发送的字符类型
            email.setCharset("utf-8");
            email.setSmtpPort(465);
            email.setSSLOnConnect(true);
            //设置收件人
            email.addTo(userEmail);
            //发送人的邮箱为自己的，用户名可以随便填
            email.setFrom("uncontrollably@163.com","uncontrollably");
            //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            email.setAuthentication("uncontrollably@163.com","qq1522551209");
            //设置发送主题
            email.setSubject("验证码");
            //设置发送内容
            if (type == SIGNIN){
                email.setMsg("您正在进行注册，验证码为:" + code+"，该码有效期为 5 分钟，该码只能使用一次！");
            }
            else if (type == UPDATAPWD){
                email.setMsg("您正在进行修改密码，验证码为:" + code+"，该码有效期为 5 分钟，该码只能使用一次！");
            }
            //发送
            email.send();
            flag = true ;
        }catch (EmailException e){

        }
        return flag;
    }



}
