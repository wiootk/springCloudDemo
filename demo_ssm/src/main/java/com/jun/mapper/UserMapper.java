package com.jun.mapper;

import com.jun.entity.User;
import com.jun.mapper.provider.UserDaoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Delete("drop table user if exists")
    void dropTable();

    @Insert("create table user (id bigint generated by default as identity, age integer, name varchar(255), primary key (id))")
    void createTable();

    //三种传参方式
    @Insert("insert into user(name,age) values(#{name},#{age})")
//    id递增，回传ID
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insert(User user);
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insertByParm(@Param("name") String name, @Param("age") String age);
    @Insert("insert into user(name,age) values(#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);






    @Select("select id,name,age from user")
    List<User> findAll();
    //使用UserDaoProvider类的findUser方法来生成动态sql
    @SelectProvider(type = UserDaoProvider.class, method = "findUser")
    List<User> findAll2(User user);
    //动态sql的List参数处理
    @SelectProvider(type = UserDaoProvider.class, method = "find")
    public List<Map> findAll3(List<User> list);

    @Select("select id,name,age from user where name like #{name}")
    List<User> findByNameLike(String name);

//    @Results(id="userResp",value={
//            @Result(property="nnNn",column="NN_NN")
//    })
//////    在其他方法重复使用
////    @ResultMap("userResp")
    //返回结果处理
    @Results({
//            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "age", column = "AGE")
    })
    @Select("select id, name,age from user where id = #{id}")
    User getById(long id);

    @Delete("delete from user")
    void deleteAll();
}