package com.jun.mapper.provider;

import com.jun.entity.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;


public class UserDaoProvider {
    public String findUserById(User user) {
        String sql = "SELECT * FROM user";
        if(user.getId()!=0){
            sql += " where id = #{id}";
        }
        return sql;
    }
    public String findUser(User user) {
        return new SQL(){{
            SELECT("id,name");
            SELECT("other");
            FROM("user");
            if(user.getId()!=0){
                WHERE("id = #{id}");
            }
            if(user.getName()!=null){
                WHERE("name = #{name}");
            }
        }}.toString();
    }
    public String find(Map map) {
        List<User> list = (List<User>) map.get("list");
        return new SQL(){{
            SELECT("id,name");
            SELECT("other");
            FROM("user");
            StringBuilder ids=new StringBuilder();
            ids.append(" ( ");
            for(User u:list){
                ids.append("#{id} ,");
            }
            if(ids.lastIndexOf(",")>1){
                ids.subSequence(0,ids.length()-1);
                ids.append(" )");
                WHERE("id in "+ids.toString());
            }
        }}.toString();
    }
}









