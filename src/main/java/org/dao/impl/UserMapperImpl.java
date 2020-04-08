package org.dao.impl;

import org.dao.IUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.vo.QueryVo;
import org.vo.User;


import java.util.List;

public class UserMapperImpl implements IUserMapper {

    private SqlSessionTemplate sqlSession ;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private IUserMapper getMapper(){
        return sqlSession.getMapper(IUserMapper.class);
    }

    @Override
    public boolean add(User user) throws Exception {
        return getMapper().add(user);
    }

    @Override
    public boolean upData(QueryVo queryVo) throws Exception {
        return getMapper().upData(queryVo);
    }

    @Override
    public boolean find(String email) throws Exception {
        return getMapper().find(email);
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> users = getMapper().findAll();
        return users;
    }

    @Override
    public User loginCheck(QueryVo queryVo) throws Exception {
        return getMapper().loginCheck(queryVo);
    }
}
