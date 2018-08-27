package com.jk.mapper.wchen;


import com.jk.model.BanXing;
import com.jk.model.JiangShi;
import com.jk.model.KeCheng;
import com.jk.model.QianTaiYongHu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
