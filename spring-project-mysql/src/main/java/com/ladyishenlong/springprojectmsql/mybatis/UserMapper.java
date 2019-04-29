package com.ladyishenlong.springprojectmsql.mybatis;

import com.ladyishenlong.springprojectmsql.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} ")
    UserModel findByUsername(String username);

}
