package com.example.userservice.dao;

import com.example.userservice.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("insert into tb_user (name, age, email) values(#{name}, #{age})")
    int save(User user);
    @Update("update tb_user set name = #{name}, age = #{age}, email = #{email} where id = #{id}")
    int update(User user);
    @Delete("delete from tb_user where id = #{id}")
    int delete(Integer id);
    @Select("select id, name, age, email from tb_user where id = #{id}")
    User getById(Integer id);
    @Select("select id, name, age, email from tb_user")
    List<User> getAll();
}
