package com.questionnaire.mapper;

import com.questionnaire.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Insert("insert into users(username,password,questionnaireid) values(#{username},#{password},#{questionnaireid})")
    void insert(Users users);

    @Select("select * from users where username=#{username}")
    Users isUnique(String username);

    @Select("select * from users where username=#{username} and password=#{password}")
    Users logInfo(Users users);

    @Update("update users set questionnaireid=#{id} where username=#{username}")
    void setId(Integer id,String username);

    @Select("select questionnaireid from users where username=#{username}")
    Integer search(String username);

    @Update("update users set questionnaireid=null where questionnaireid=#{id}")
    void deleteId(Integer id);
}
