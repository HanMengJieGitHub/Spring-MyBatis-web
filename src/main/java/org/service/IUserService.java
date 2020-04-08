package org.service;

import org.vo.QueryVo;
import org.vo.User;

import java.util.List;

public interface IUserService {

    public boolean add(User user);

    public boolean upData(QueryVo queryVo) ;

    public boolean find(String email) ;

    User loginCheck(QueryVo queryVo);

    List<User> findAll();

}
