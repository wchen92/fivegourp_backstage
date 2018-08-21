package com.jk.service.tysheng;

import com.jk.mapper.tysheng.ITyshengMapper;
import com.jk.model.JiangShi;
import com.jk.model.WenDa;
import com.jk.model.ZhangJie;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:30
 * @ Description：
 * @ Version:
 */
@Service
public class TyshengServiceImpl implements ITyshengService{
    @Resource
    private ITyshengMapper TyshengMapper;



    /**
　　* @Description: 教师表的查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 16:09
　　*/
    @Override
    public Map<String, Object> queryjslist2(Integer page, Integer rows, JiangShi teacher) {
        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();

        List<JiangShi> userlist;
        userlist = TyshengMapper.queryjslist2(page,rows,teacher);
        stirngObjectHashMap.put("rows",userlist);
        long total = TyshengMapper.total1(teacher);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }
/**
　　* @Description: TODO
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 16:10
　　*/
    @Override
    public void saveteacher(JiangShi teacher) {

        teacher.setJiangshiid(UUID.randomUUID().toString().replaceAll("-",""));
        TyshengMapper.saveteacher(teacher);
    }
/**
　　* @Description: 教师表的修改之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 21:22
　　*/
    @Override
    public JiangShi queryteacherbyid(String teacherid) {

        return  TyshengMapper.queryteacherbyid(teacherid);
    }
/**
　　* @Description:教师表的删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 22:00
　　*/
    @Override
    public void deleteteacher(String ss) {
        TyshengMapper.deleteteacher(ss);
    }
/**
　　* @Description: 教师表的修改之保存
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 22:00
　　*/
    @Override
    public void updateteacher(JiangShi teacher) {
        TyshengMapper.updateteacher(teacher);
    }


    /**
    　　* @Description: 章节表的数据查询
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 谭永生
    　　* @date 2018/8/11 9:05
    　　*/
    @Override
    public Map<String, Object> queryzjlist(Integer page, Integer rows, ZhangJie zj) {

        HashMap<String, Object> stirngObjectHashMap = new HashMap<String, Object>();
        List<ZhangJie> userlist;
        userlist = TyshengMapper.queryzjlist(page,rows,zj);
        stirngObjectHashMap.put("rows",userlist);
        long total = TyshengMapper.total2(zj);
        stirngObjectHashMap.put("total",total);
        return stirngObjectHashMap;
    }
/**
　　* @Description: 章节表的数据删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:15
　　*/
    @Override
    public void deletesection(String ss) {

        TyshengMapper.deletesection(ss);
    }
/**
　　* @Description: 章节表的数据新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:23
　　*/
    @Override
    public void savesection(ZhangJie zj) {

        zj.setZhangjieid(UUID.randomUUID().toString().replaceAll("-",""));
        TyshengMapper.savesection(zj);
    }
/**
　　* @Description: 章节表根据ID的修改之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:40
　　*/
    @Override
    public ZhangJie querysectionbyid(String zhangjieid) {
        return TyshengMapper.querysectionbyid(zhangjieid);
    }
/**
　　* @Description: 章节表的修改保存
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:57
　　*/
    @Override
    public void updatesection(ZhangJie zj) {
        TyshengMapper.updatesection(zj);
    }
/**
　　* @Description: 问答专题
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/17 20:41
　　*/
    @Override
    public List<WenDa> getTreeList(Integer id) {


        return TyshengMapper.getTreeList(id);
    }
/**
　　* @Description:问答的新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 15:55
　　*/
    @Override
    public void savewd(WenDa wd) {
        wd.setWdate( new Date());
        TyshengMapper.savewd(wd);
    }
/**
　　* @Description:回复之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 20:16
　　*/
    @Override
    public WenDa queryhuifu666(Integer id) {

        return  TyshengMapper.queryhuifu666(id);
    }
/**
　　* @Description: 回复
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 20:27
　　*/
    @Override
    public void savehuifu(WenDa wd) {

        wd.setWdate( new Date());
        TyshengMapper.savehuifu(wd);

    }


}
