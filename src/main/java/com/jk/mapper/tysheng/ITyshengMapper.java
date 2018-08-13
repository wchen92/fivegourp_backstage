package com.jk.mapper.tysheng;

import com.jk.model.JiangShi;
import com.jk.model.ZhangJie;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ITyshengMapper {

/**
　　* @Description: 教师表的数据查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 16:11
　　*/
    @Select(" select * from jiangshi  limit #{page},#{rows}")
    List<JiangShi> queryjslist2(@Param("page")Integer page, @Param("rows")Integer rows, @Param("t")JiangShi teacher);
/**
　　* @Description: 教师表的条数查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 16:11
　　*/
    @Select(" select count(*) from jiangshi")
    long total1(@Param("t") JiangShi teacher);


/**
　　* @Description: 教师表的数据新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 16:18
　　*/
    @Insert("  insert into JiangShi (jiangshiid,jiangshiname,jiangshishenfen,jiangshijieshao)" +
            " values(#{jiangshiid},#{jiangshiname},#{jiangshishenfen},#{jiangshijieshao}) ")
    void saveteacher(JiangShi teacher);



/**
　　* @Description: 教师表的修改之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 21:10
　　*/
    @Select(" select * from jiangshi where jiangshiid=#{teacherid}")
    JiangShi queryteacherbyid(String teacherid);
/**
　　* @Description: 教师表的删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 22:02
　　*/
    @Delete(" delete from jiangshi where jiangshiid=${jiangshiid} ")
    void deleteteacher(@Param("jiangshiid") String ss);
/**
　　* @Description: 教师表的修改的保存
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 22:03
　　*/

    @Update(" update jiangshi set jiangshiname=#{jiangshiname},jiangshishenfen=#{jiangshishenfen},jiangshijieshao =#{jiangshijieshao} where jiangshiid=#{jiangshiid}")
    void updateteacher(JiangShi teacher);
/**
　　* @Description: 章节表的数据查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 9:08
　　*/
   @Select(" select * from ZhangJie  limit #{page},#{rows}")
    List<ZhangJie> queryzjlist(@Param("page") Integer page, @Param("rows") Integer rows,@Param("zj")  ZhangJie zj);
/**
　　* @Description: 查询章节表的数据总条数
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 9:08
　　*/
     @Select(" select count(*) from ZhangJie")
    long total2(@Param("zj") ZhangJie zj);
/**
　　* @Description: 章节表的数据删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:16
　　*/
   @Delete(" delete from ZhangJie where zhangjieid=${zhangjieid} ")
    void deletesection(@Param("zhangjieid") String ss);
/**
　　* @Description: 章节表的数据新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:25
　　*/
@Insert("  insert into ZhangJie (zhangjieid,zhangjiename,shipin,shoufeistatus)" +
        " values(#{zhangjieid},#{zhangjiename},#{shipin},#{shoufeistatus}) ")
    void savesection(ZhangJie zj);
/**
　　* @Description: 章节表根据ID的修改之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:41
　　*/
     @Select(" select * from ZhangJie  where zhangjieid=#{zhangjieid}")
    ZhangJie querysectionbyid(@Param("zhangjieid") String zhangjieid);
/**
　　* @Description: 章节表根据ID的修改之保存
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:58
　　*/
@Update(" update ZhangJie set zhangjiename=#{zhangjiename},shipin=#{shipin},shoufeistatus =#{shoufeistatus} where zhangjieid=#{zhangjieid}")
    void updatesection(ZhangJie zj);
}
