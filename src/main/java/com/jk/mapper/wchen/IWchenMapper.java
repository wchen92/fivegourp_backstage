package com.jk.mapper.wchen;


import com.jk.model.KeCheng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IWchenMapper {
    //查询数据库数据
    @Select(" select * from kecheng ")
    List<KeCheng> selectmysqladdgosolr();
}
