package com.jk.controller.tysheng.index;

import com.jk.model.JiangShi;
import com.jk.model.WenDa;
import com.jk.model.ZhangJie;
import com.jk.service.tysheng.ITyshengService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:24
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("tyshengIndex")
public class TyshengIndexController {


    @Resource
    private ITyshengService TyshengService;
    /**
    　　* @Description:查询主页
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 谭永生
    　　* @date 2018/8/10 20:39
    　　*/
    @RequestMapping("queryshowjsp")
    public  String queryshowjsp(){


        return "wjyi/showzhu";
    }

/**
　　* @Description: 查询教师表
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/10 20:40
　　*/
    @RequestMapping("queryjs")
    public  String queryjs(){


        return "tys/showJsData";
    }
/**
　　* @Description: 教师表的新增跳转页面
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
   * @author 谭永生
　　* @date 2018/8/10 20:40
　　*/
    @RequestMapping("saveteacherjsp")
    public  String saveteacherjsp(){

        return "tys/saveteacher";
    }

/**
　　* @Description: 跳转教师表的修改页面
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 9:33
　　*/
    @RequestMapping("queryteacherbyid")
    public  String  queryteacherbyid(String jiangshiid, Model model){

        JiangShi js=  TyshengService.queryteacherbyid(jiangshiid);

        model.addAttribute("js",js);

        return "tys/saveteacher";
    }

/**
　　* @Description: 跳转章节查询页面
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 9:32
　　*/

    @RequestMapping("queryzj")
    public  String queryzj(){
        return "tys/showSectionData";
    }

/**
　　* @Description: 跳转章节表的新增页面
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:36
　　*/
    @RequestMapping("savesectionjsp")
    public  String savesectionjsp(){
        return "tys/savesection";
    }

/**
　　* @Description: 章节表根据ID的修改之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/11 10:39
　　*/
    @RequestMapping("querysectionbyid")
    public  String  querysectionbyid(String zhangjieid, Model model){

        ZhangJie zj=  TyshengService.querysectionbyid(zhangjieid);

        model.addAttribute("zj",zj);


        return "tys/savesection";
    }


   /**
   　　* @Description:问答专题
   　　* @param ${tags}
   　　* @return ${return_type}
   　　* @throws
   　　* @author 谭永生
   　　* @date 2018/8/17 20:44
   　　*/
    @RequestMapping("queryTreeList")

    public String queryTreeList(Model model) {
        Integer id=0;
        List<WenDa> treeList = getTreeList(id);
        model.addAttribute("treeList", treeList);

        return "tys/wenda";
    }
    public List<WenDa> getTreeList(Integer id) {

        List<WenDa> list=TyshengService.getTreeList(id);
        for (WenDa wenDa : list) {
            Integer id2 = wenDa.getId();
            List<WenDa> treeList = getTreeList(id2);

            wenDa.setList(treeList);
        }
        return list;
    }
/**
　　* @Description: 问答专题之提问
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 11:49
　　*/
    @RequestMapping("savewenda")
    public  String savewenda(){

        return "tys/saveWenDa";

    }
/**
　　* @Description: 回复之查询
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 谭永生
　　* @date 2018/8/20 20:15
　　*/

    @RequestMapping("queryhuifu666")
    public  String queryhuifu666(Model model,Integer id){

       WenDa hf=  TyshengService.queryhuifu666(id);

      model.addAttribute("hf",hf);


        return "tys/huifu";

    }
}
