package com.jk.controller.tysheng;

import com.jk.model.JiangShi;

import com.jk.model.WenDa;
import com.jk.model.ZhangJie;
import com.jk.service.tysheng.ITyshengService;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:24
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("tysheng")
public class TyshengController {
    @Resource
    private ITyshengService TyshengService;

    //讲师表查询


/**
　　* @Description: 教师列表查询
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 15:28
　　*/


    @RequestMapping("queryjslist2")
    public Map<String,Object> queryjslist2(Integer page,Integer rows,JiangShi teacher){
        Map<String,Object> list = TyshengService.queryjslist2(page,rows,teacher);
        return list;
    }

/**
　　* @Description: 教师表数据新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 15:31
　　*/
    @RequestMapping("saveteacher")
    @ResponseBody
    public  void  saveteacher(JiangShi teacher){

        TyshengService.saveteacher(teacher);

    }

/**
　　* @Description: 教师表的删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 21:57
　　*/
    @RequestMapping("deleteteacher")
    @ResponseBody
    public  void  deleteteacher(String ss){

        TyshengService.deleteteacher(ss);
        System.out.println(ss);
    }
/**
　　* @Description: 教师表修改的保存
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 21:58
　　*/
    @RequestMapping("updateteacher")
    @ResponseBody
    public  void  updateteacher(JiangShi teacher){

        TyshengService.updateteacher(teacher);

    }

/**
　　* @Description: 章节表的数据查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 9:04
　　*/
    @RequestMapping("queryzjlist")
    public Map<String,Object> queryzjlist(Integer page,Integer rows,ZhangJie zj){
        Map<String,Object> list = TyshengService.queryzjlist(page,rows,zj);
        return list;
    }

/**
　　* @Description: 章节表的数据删除
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:11
　　*/
    @RequestMapping("deletesection")
    @ResponseBody
    public  void  deletesection(String ss){

        TyshengService.deletesection(ss);

    }
/**
　　* @Description: 章节表的数据新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:22
　　*/
    @RequestMapping("savesection")
    @ResponseBody
    public  void  savesection(ZhangJie zj){

        TyshengService.savesection(zj);

    }
/**
　　* @Description: 章节表的修改保存
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:52
　　*/

    @RequestMapping("updatesection")
    @ResponseBody
    public  void  updatesection(ZhangJie zj){

        TyshengService.updatesection(zj);

    }


/**
　　* @Description: 问答的新增
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 15:53
　　*/
    @RequestMapping("savawendaone")
    @ResponseBody
    public  void  savewd(WenDa wd){

        TyshengService.savewd(wd);

    }


/**
　　* @Description: 回复
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 20:26
　　*/
    @RequestMapping("savehuifu")
    @ResponseBody
    public  void  savehuifu(WenDa wd){

        TyshengService.savehuifu(wd);


        System.out.println(wd);
    }

}
