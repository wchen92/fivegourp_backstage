package com.jk.mapper.wchen;


import com.jk.model.KeCheng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IWchenMapper {
    //查询数据库数据
    @Select(" select * from kecheng ")
    List<KeCheng> selectmysqladdgosolr();

    @Select("select t1.text from t_user t1 where t1.userid = #{userid}")
    String pluseridselecttomysql(@Param("userid") String userid);
}
