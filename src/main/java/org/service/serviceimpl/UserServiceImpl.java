package org.service.serviceimpl;

import org.dao.impl.UserMapperImpl;
import org.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.QueryVo;
import org.vo.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserMapperImpl userMapperImpl = context.getBean("userMapperImpl",UserMapperImpl.class);

    @Override
    public boolean add(User user){
        try {
            return userMapperImpl.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean upData(QueryVo queryVo) {
        try {
            return userMapperImpl.upData(queryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean find(String email) {
        try {
            return userMapperImpl.find(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public User loginCheck(QueryVo queryVo) {
        try {
            return userMapperImpl.loginCheck(queryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    @Override
    public List<User> findAll() {
        try {
            return userMapperImpl.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
