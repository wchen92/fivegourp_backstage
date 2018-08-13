package com.jk.mapper.zqshun;

import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IZqshunMapper {


    //班型查询
    @Select(" select banxingid,banxingname from banxing  limit #{page},#{rows}")
    List<BanXing> querybanxing(@Param("page") Integer page, @Param("rows")Integer rows,@Param("banxing")BanXing banxing);

    @Select(" select count(*) from banxing")
    long total(@Param("banxing")BanXing banxing);
    //班型删除
    @Delete(" delete from banxing where banxingid in (#{ids}) ")
    void deletebanxing(@Param("ids") String ids);

    //班型新增
    @Insert(" insert into banxing values(#{banxingid},#{banxingname}) ")
    void addbanxing(BanXing banxing);

    //班型回显
    @Select(" select * from banxing where banxingid = #{zid} ")
    BanXing selectbanxing(@Param("zid") String zid);

    //班型修改
    @Update(" update banxing set banxingname=#{banXing.banxingname} where banxingid=#{banXing.banxingid}")
    void updatebanxing(@Param("banXing")BanXing banXing);

    //课程查询
    @Select(" select k.kechengid,k.kechengname,k.kechengprice,k.keshishu,k.kechengphoto,k.kechengjieshao,k.huiyuanstatus,k.shenhestatus from kecheng k limit #{page},#{rows}")
    List<KeCheng> querykecheng(@Param("page")Integer page, @Param("rows")Integer rows,@Param("kecheng")KeCheng kecheng);

    @Select(" select count(*) from kecheng")
    long totalkecheng(@Param("kecheng")KeCheng kecheng);

    //课程管理删除
    @Delete(" delete from kecheng where kechengid in (#{ids}) ")
    void deletekecheng(@Param("ids")String ids);

    //课程管理新增
    @Insert(" insert into kecheng(kechengid,kechengname,kechengprice,keshishu,kechengjieshao,huiyuanstatus,shenhestatus,kechengphoto) values(#{kechengid},#{kechengname},#{kechengprice},#{keshishu},#{kechengjieshao},#{huiyuanstatus},#{shenhestatus},#{kechengphoto}) ")
    void addkecheng(KeCheng keCheng);

    //课程管理回显
    @Select(" select * from kecheng where kechengid = #{sid} ")
        KeCheng selectkecheng(String sid);

    //课程管理修改
    @Update(" update kecheng set kechengname=#{keCheng.kechengname},kechengprice=#{keCheng.kechengprice},keshishu=#{keCheng.keshishu},kechengjieshao=#{keCheng.kechengjieshao},huiyuanstatus=#{keCheng.huiyuanstatus},shenhestatus=#{keCheng.shenhestatus},kechengphoto=#{keCheng.kechengphoto} where kechengid=#{keCheng.kechengid} ")
    void updatekecheng(@Param("keCheng")KeCheng keCheng);
}
