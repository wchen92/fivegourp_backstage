package com.jk.mapper.zqshun;

import com.jk.model.BanXing;
import com.jk.model.KeCheng;
import com.jk.model.ZhangJie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IZqshunMapper {


    //查询班型管理
    @Select(" select banxingid,banxingname from banxing  limit #{start},#{rows}")
    List<BanXing> querybanxing(@Param("start") Integer start, @Param("rows")Integer rows,@Param("banxing")BanXing banxing);

    @Select(" select count(*) from banxing")
    long total(@Param("banxing")BanXing banxing);
    //删除班型管理
    @Delete(" delete from banxing where banxingid in (#{ids}) ")
    void deletebanxing(@Param("ids") String ids);

    //新增班型管理
    @Insert(" insert into banxing values(#{banxingid},#{banxingname}) ")
    void addbanxing(BanXing banxing);

    //回显班型管理
    @Select(" select * from banxing where banxingid = #{zid} ")
    BanXing selectbanxing(@Param("zid") String zid);

    //修改班型管理
    @Update(" update banxing set banxingname=#{banXing.banxingname} where banxingid=#{banXing.banxingid}")
    void updatebanxing(@Param("banXing")BanXing banXing);

    //查询课程管理
    @Select(" select k.kechengid,k.kechengname,k.kechengprice,k.keshishu,k.kechengphoto,k.kechengjieshao,k.huiyuanstatus,k.shenhestatus from kecheng k limit #{start},#{rows}")
    List<KeCheng> querykecheng(@Param("start")Integer start, @Param("rows")Integer rows,@Param("kecheng")KeCheng kecheng);

    @Select(" select count(*) from kecheng")
    long totalkecheng(@Param("kecheng")KeCheng kecheng);

    //删除课程管理
    @Delete(" delete from kecheng where kechengid in (#{ids}) ")
    void deletekecheng(@Param("ids")String ids);

    //新增课程管理
    @Insert(" insert into kecheng(kechengid,kechengname,kechengprice,keshishu,kechengjieshao,huiyuanstatus,shenhestatus,kechengphoto) values(#{kechengid},#{kechengname},#{kechengprice},#{keshishu},#{kechengjieshao},#{huiyuanstatus},#{shenhestatus},#{kechengphoto}) ")
    void addkecheng(KeCheng keCheng);

    //回显课程管理
    @Select(" select * from kecheng where kechengid = #{sid} ")
        KeCheng selectkecheng(String sid);

    //修改课程管理
    @Update(" update kecheng set kechengname=#{keCheng.kechengname},kechengprice=#{keCheng.kechengprice},keshishu=#{keCheng.keshishu},kechengjieshao=#{keCheng.kechengjieshao},huiyuanstatus=#{keCheng.huiyuanstatus},shenhestatus=#{keCheng.shenhestatus},kechengphoto=#{keCheng.kechengphoto} where kechengid=#{keCheng.kechengid} ")
    void updatekecheng(@Param("keCheng")KeCheng keCheng);


    //查询章节管理
    @Select(" select z.zhangjieid,z.zhangjiename,z.shipin,z.shoufeistatus from zhangjie z  limit #{start},#{rows} ")
    List<ZhangJie> queryzhangjie(@Param("start") Integer start, @Param("rows") Integer rows, @Param("zhangJie") ZhangJie zhangJie);

    @Select(" select count(*) from zhangjie ")
    long totalzhangJie(ZhangJie zhangJie);

    //新增章节管理
    @Insert(" insert into zhangjie values(#{zhangjieid},#{zhangjiename},#{shipin},#{shoufeistatus}) ")
    void addzhangjie(ZhangJie zhangJie);

    //删除章节管理
    @Delete(" delete from zhangjie where zhangjieid in (#{ids}) ")
    void deletezhangcheng(@Param("ids")String ids);


    //回显章节管理
    @Select(" select * from zhangjie where zhangjieid = #{zjid} ")
    ZhangJie zhangjieupdate(@Param("zjid")String zjid);

    //修改章节管理
    @Update(" update zhangjie set zhangjiename=#{zhangJie.zhangjiename},shoufeistatus=#{zhangJie.shoufeistatus},shipin=#{zhangJie.shipin} where zhangjieid=#{zhangJie.zhangjieid} ")
    void updatezhangjie(@Param("zhangJie")ZhangJie zhangJie);

    //课程下所属章节
  //  @Select(" select z.zhangjieid,z.zhangjiename,z.shipin,z.shoufeistatus from zhangjie z,kecheng_zhangjie k where z.zhangjieid=k.zhangjieid and k.kechengid=${ids} ")
   @Select("  SELECT * FROM zhangjie z WHERE z.zhangjieid IN ( SELECT k.zhangjieid FROM kecheng_zhangjie k, kecheng c WHERE  c.kechengid = '1')")
   List  selectzhangjie(String ids);


}
