package com.jk.mapper.wchen;


import com.jk.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IWchenMapper {
    //查询数据库数据
    @Select("SELECT\n" +
            "  kc.kechengid kechengid,kc.kechengname kechengname,kc.kechengprice kechengprice,\n" +
            "  kc.keshishu keshishu,kc.kechengphoto kechengphoto,kc.kechengjieshao kechengjieshao,\n" +
            "  kc.huiyuanstatus huiyuanstatus,kc.shenhestatus shenhestatus ,\n" +
            "  bx.banxingname banxing ,js.jiangshiname jiangshi\n" +
            "FROM \n" +
            "\tkecheng kc,\n" +
            "\tjiangshi js,\n" +
            "\tkecheng_jiangshi kcandjs,\n" +
            "\tbanxing bx,\n" +
            "\tbanxing_kecheng bxandkc\n" +
            "WHERE\n" +
            "\tkcandjs.kechengid = kc.kechengid\n" +
            "AND kcandjs.jiangshiid = js.jiangshiid\n" +
            "AND bxandkc.kechengid = kc.kechengid\n" +
            "AND bxandkc.banxingid = bx.banxingid")
    List<KeCheng> selectmysqladdgosolr();

    @Select("select *  from qiantaiyonghu t1\n" +
            " where t1.yonghuid = #{userid}")
    QianTaiYongHu pluseridselecttomysql(@Param("userid") String userid);

    @Select(" select t1.* from qiantaiyonghu t1 \n" +
            " where t1.yonghuid = #{showuserid} ")
    QianTaiYongHu selecttitle(@Param("showuserid") String showuserid);


    @Select(" select * from banxing")
    List<BanXing> allselectbanxing();

    @Select(" select * from jiangshi")
    List<JiangShi> allselectjiaoshi();


    @Select("select us.userid userid  from \n" +
            " t_user us,t_role ro,t_user_role usandro\n" +
            "   where usandro.roleid = ro.roleid \n" +
            "   and usandro.userid = us.userid\n" +
            "   and ro.text = '客服人员'")
    List<String> selectorroletouserid();

    @Insert(" insert into peixun(id,name,sex,shouji,weixinhao,xueli,biyeshijian,xinzi,zhuangtai,zhidingchuliid,chulizhuangtai,qqhao) values(#{id},#{name},#{sex},#{shouji},#{weixinhao},#{xueli},#{biyeshijian},#{xinzi},#{zhuangtai},#{zhidingchuliid},#{chulizhuangtai},#{qqhao})")
    void addpeixun(peixun px);

    @Select(" select COUNT(*) from peixun px where px.zhidingchuliid = #{userid} and px.chulizhuangtai = 1 ")
    long selectfenpeicount(@Param("userid") String userid);

    @Select(" select * from peixun px where px.zhidingchuliid = #{userid} and px.chulizhuangtai = 1 limit #{start},#{rows}")
    List<peixun> selectpeixun(@Param("userid")String userid,@Param("start") int start,@Param("rows")Integer rows);

    @Update(" update peixun px set px.chulizhuangtai = 2 where px.id = #{id}")
    void peixunok(@Param("id") String id);

    @Select(" select COUNT(*) from peixun px where px.zhidingchuliid = #{userid} and px.chulizhuangtai = 2 ")
    long selectfenpeicountok(String userid);
    @Select(" select * from peixun px where px.zhidingchuliid = #{userid} and px.chulizhuangtai = 2 limit #{start},#{rows}")
    List<peixun> selectpeixunok(@Param("userid")String userid,@Param("start") int start,@Param("rows")Integer rows);

    @Update(" update peixun px set jieguo = #{jieguo} where px.id = #{id}")
    void addjieguo(@Param("id") String id, @Param("jieguo")String jieguo);
}
