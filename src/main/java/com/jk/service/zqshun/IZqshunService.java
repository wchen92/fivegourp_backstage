package com.jk.service.zqshun;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IZqshunService {

    //班型查询
    Map<String,Object> querybanxing(Integer page,Integer rows,BanXing banxing);

    //班型删除
    void deletebanxing(String ids);

    //班型新增
    void addbanxing(BanXing banxing);

    //班型回显
    BanXing selectbanxing(String zid);

    //班型修改
    void updatebanxing(BanXing banXing);

    //课程查询
    Map<String,Object> querykecheng(Integer page, Integer rows, KeCheng kecheng);

    //课程删除
    void deletekecheng(String ids);

    //课程新增
    void addkecheng(KeCheng keCheng);

    //课程回显
    KeCheng selectkecheng(String sid);

    //课程修改
    void updatekecheng(KeCheng keCheng);

    //oss图片
    String uploadImg(MultipartFile imgs) throws IOException;

    //查询章节管理
    Map<String,Object> queryzhangjie(Integer page, Integer rows, ZhangJie zhangJie);

    //新增章节管理
    void addzhangjie(ZhangJie zhangJie);

    //章节视频上传
    HashMap<String,Object> Upload(MultipartFile file) throws IOException ;

    //删除章节管理
    void deletezhangcheng(String ids);

    //回显章节管理
    ZhangJie zhangjieupdate(String zjid);

    //修改章节管理
    void updatezhangjie(ZhangJie zhangJie);


    //课程下所属章节
    List<ZhangJie> selectzhangjie(String idzj);

    //过滤敏感词
    void mingan(String str);

    Integer selecthy(String id);

    List<JiangShi> selecttiche();

    //课程新增对应版型
    List<BanXing> selectkctobanxing();
}
