package com.jk.mapper.lshun;

import com.jk.model.*;
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

    @Select("SELECT\n" +
            "\tt2.huiyuanstatus huiyuanstatus,\n" +
            "\tt2.kechengid kechengid,\n" +
            "\tt2.kechengjieshao kechengjieshao,\n" +
            "\tt2.kechengname kechengname,\n" +
            "\tt2.kechengphoto kechengphoto,\n" +
            "\tt2.kechengprice kechengprice,\n" +
            "\tt2.keshishu keshishu,\n" +
            "\tt2.shenhestatus shenhestatus,\n" +
            "\tt1.liulanshuliang liulanliang\n" +
            "FROM\n" +
            "\tliulan t1,\n" +
            "\tkecheng t2\n" +
            "WHERE\n" +
            "\tt1.kechengid = t2.kechengid\n" +
            "AND t2.shenhestatus = 1")
    List<KeCheng> selectkechenglist();
    @Select("select * from zhangjie")
    List<ZhangJie> selectdaganglist();
    @Select("select t1.kechengname kechengname,t1.keshishu keshishu,t1.kechengprice kechengprice,t2.liulanshuliang  liulanliang from kecheng t1, liulan t2 where t1.kechengid= t2.kechengid")
    List<KeCheng> selectxiangqinglist();
    @Select("select t1.kechengname,t1.kechengprice from kecheng t1 where kechengid='7743f23135f140279e486307a49c282a'")
    List<KeCheng> selectpricelist();


    //查询课程信息
    @Select(" select * from kecheng kc where kc.kechengid  = #{wchenkcdi}")
    KeCheng selectkecheng(@Param("wchenkcdi") String wchenkcdi);
    //查询浏览数
    @Select(" select * from liulan ll,kecheng kc\n" +
            " where \n" +
            "ll.kechengid = kc.kechengid\n" +
            "and kc.kechengid = #{wchenkcdi}")
    Liuyan selectkcorcs(@Param("wchenkcdi")String wchenkcdi);
   //查询对应章节
    @Select("   select * from \n" +
            "  zhangjie zj,kecheng kc,kecheng_zhangjie kcandzj\n" +
            "  where kcandzj.kechengid  = kc.kechengid \n" +
            "  and kcandzj.zhangjieid = zj.zhangjieid\n" +
            "  and kc.kechengid= #{wchenkcdi}")
    List<ZhangJie> selectorzj(@Param("wchenkcdi") String wchenkcdi);

    //查询章节数（课时数）
    @Select("   select COUNT(*) from \n" +
            "  zhangjie zj,kecheng kc,kecheng_zhangjie kcandzj\n" +
            "  where kcandzj.kechengid  = kc.kechengid \n" +
            "  and kcandzj.zhangjieid = zj.zhangjieid\n" +
            "  and kc.kechengid= #{wchenkcdi}")
    long selectajcount(@Param("wchenkcdi") String wchenkcdi);

    //根据课程id查询第一章视频路径
   @Select("select zj.shipin from\n" +
           "zhangjie zj,kecheng kc,kecheng_zhangjie kcandzj\n" +
           " where kcandzj.kechengid  = kc.kechengid\n" +
           " and kcandzj.zhangjieid = zj.zhangjieid\n" +
           "and kc.kechengid= #{wchenkcdi}\n" +
           "LIMIT 0,1")
    String shipinshowselect(@Param("wchenkcdi") String wchenkcdi);
    //根据文章id查询文章路径
    @Select(" select t1.shipin from zhangjie t1 \n" +
            " where t1.zhangjieid = #{zhanjieid} ")
    String selectzhangjieorid(@Param("zhanjieid") String zhanjieid);
}
