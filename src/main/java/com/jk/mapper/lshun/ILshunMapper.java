package com.jk.mapper.lshun;

import com.jk.model.User;
import org.apache.ibatis.annotations.Select;

public interface ILshunMapper {
    //登陆
    @Select("select * from t_user t where   t.text=#{text} and t.userstatus=1")
    User queryUserByName(String text);
}
