package com.questionnaire.mapper;

import com.questionnaire.pojo.Bytedance;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface BytedanceMapper {

    @Select("select *from bytedance")
    List<Bytedance> list();

    @Delete("delete from bytedance where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into bytedance(username,age, know, app, short_video, publish, spend_time, shortcoming, recharge, activity, innovation, hope, agree, ability, prospect) values(#{username},#{age}, #{know}, #{app}, #{shortVideo}, #{publish}, #{spendTime}, #{shortcoming}, #{recharge}, #{activity}, #{innovation}, #{hope}, #{agree}, #{ability}, #{prospect})")
    void insert(Bytedance bytedance);

    @Select("select id from bytedance where id>= all(select id from bytedance )")
    Integer getId();

    @Select("select * from bytedance where id=#{id};")
    Bytedance search(Integer id);

    void update(Bytedance bytedance);
}
