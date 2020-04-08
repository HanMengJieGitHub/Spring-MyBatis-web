package org.dao;

import org.vo.QueryVo;
import org.vo.User;

import java.util.List;

public interface IUserMapper{
//    @Insert("insert into User values(null,#{name},#{email},#{pwd})")
    boolean add(User user) throws Exception;
//    @Update("update User set pwd=#{queryVo.pwd} where email=#{queryVo.email}")
    boolean upData(QueryVo queryVo) throws Exception ;
//    @Select("select * from User where email=#{email}")
    boolean find(String email) throws Exception;
//    @Select("select * from User where email=#{queryVo.email} and pwd=#{queryVo.pwd}")
    User loginCheck(QueryVo queryVo) throws Exception;
//    @Select("select * from User")
    List<User> findAll() throws Exception;

}
