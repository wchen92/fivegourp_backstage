package com.jk.mapper.lshun;

import com.jk.model.GuangGaoBiao;
import com.jk.model.User;
import org.apache.ibatis.annotations.*;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface ILshunMapper {
    //登陆
    @Select("select * from t_user t where   t.text=#{text} and t.userstatus=1")
     User queryUserByName(String text);
    @Select("select count(*) from guanggaobiao")
    Long queryAdvertisementCount(GuangGaoBiao guanggao);
    //查询分页
    @Select("select * from guanggaobiao  where 1=1 and guanggaoname like '%${guanggao.guanggaoname}%' limit #{start},#{end}")
    List<GuangGaoBiao> queryAdvertisementList(@Param("start") int start, @Param("end")int end, @Param("guanggao") GuangGaoBiao guanggao);
    //新增
    @Insert("insert into guanggaobiao  values (#{guanggaoid},#{money},#{guanggaoname},#{guanggaodate},#{zhanshistatus},#{chuliren},#{guanggaophoto})")
    void InsertAdvertisementList(GuangGaoBiao guanggao);
    //删除
    @Delete( "delete from  guanggaobiao where guanggaoid = ${ids}")
    void DeleteAdvertisementList(@Param("ids") String ids);
    //回显
    @Select("select * from guanggaobiao where guanggaoid = #{id}")
    GuangGaoBiao queryAdvertisementById(@Param("id") String id);
    @Update("update guanggaobiao set money=#{gaoBiao.money},guanggaodate=#{gaoBiao.guanggaodate},zhanshistatus=#{gaoBiao.zhanshistatus},chuliren=#{gaoBiao.chuliren},guanggaophoto=#{gaoBiao.guanggaophoto} where guanggaoid = #{gaoBiao.guanggaoid}")
    void UpdateAdvertisement(@Param("gaoBiao") GuangGaoBiao gaoBiao);
}
