package org.dao.test;

import org.junit.Test;
import org.service.serviceimpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.QueryVo;
import org.vo.User;

import java.util.List;


public class MyTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setName("testadd2");
        user.setEmail("2222111@qq.com");
        user.setPwd("1234567");
        boolean b = new UserServiceImpl().add(user);
        System.out.println(b);
    }

    @Test
    public void testUpDate() throws Exception {
        System.out.println(new UserServiceImpl().upData(new QueryVo("19194520@qq.com", "123456")));
    }

    @Test
    public void testFind() throws Exception {
        System.out.println(new UserServiceImpl().find("191945206@qq.com"));
    }

    @Test
    public void testLoginCheck() throws Exception {
        System.out.println(new UserServiceImpl().loginCheck(new QueryVo("19194520@qq.com","123456")));
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = new UserServiceImpl().findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
