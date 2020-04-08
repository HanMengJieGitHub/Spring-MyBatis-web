package org.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailTest {
    public static void main(String[] args) throws EmailException {
        //1、创建一个HtmlEmail实例对象
        HtmlEmail email = new HtmlEmail();
        //2、邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
        email.setHostName("smtp.163.com");
        //设置发送的字符类型
        email.setCharset("utf-8");
        //设置收件人
        email.addTo("1934146978@qq.com");
        //发送人的邮箱为自己的，用户名可以随便填
        email.setFrom("uncontrollably@163.com","uncontrollably");
        //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
        email.setAuthentication("uncontrollably@163.com","qq1522551209");
        //设置发送主题
        email.setSubject("xxxxx");
        //设置发送内容
        email.setMsg("汪汪汪汪汪汪汪汪汪汪");
        //发送
        email.send();
    }

}
