package com.jk.controller.wychao;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import com.jk.model.GuangGaoBiao;
import com.jk.model.KeCheng;
import com.jk.service.wychao.IWychaoService;
import com.jk.uitl.wyc.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:27
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("wychao")
public class WychaoController {
    @Resource
    private IWychaoService WychaoServiceL;
    /**
     * @ 创建者：wyc.
     * @ 创建时间：2018/8/13 9:27
     * @ Description：
     * @ Version:
     * 点击量
     */
    @RequestMapping("querydianji")
    @ResponseBody
    public String querydianji(){

            Map<String, Object> list=WychaoServiceL.querydianji();

            String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
            return json;
        }
    /**
     * @ 创建者：wyc.
     * @ 创建时间：2018/8/13 9:27
     * @ Description：
     * @ Version:
     * 购买量
     */
    @RequestMapping("querygoumai")
    @ResponseBody
    public String querygoumai(){

        Map<String, Object> list=WychaoServiceL.querygoumai();

        String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
        return json;
    }
    /**
     * @ 创建者：wyc.
     * @ 创建时间：2018/8/13 9:27
     * @ Description：
     * @ Version:
     * 日期分购量
     */
    @RequestMapping("queryshiji")
    @ResponseBody
        public String queryshiji(){

        Map<String, Object> list=WychaoServiceL.queryshiji();

        String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
        return json;
    }


    /**
     * @ 创建者：wyc.
     * @ 创建时间：2018/8/15 9:27
     * @ Description：
     * @ Version:
     * 日期广告分购量
     */

    @RequestMapping("queryguanggao")
    @ResponseBody
    public String queryguanggao(){

        Map<String, Object> list=WychaoServiceL.queryguanggao();

        String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM");
        return json;
    }



    @RequestMapping(value="querydianjigg")
     @ResponseBody
    public String DataService(HttpServletResponse  response) {
        List<Dianji> list1 = WychaoServiceL.queryShenqing();
        String path="E:\\dianji.xls";
        try {
            String title="申请表";
            String [] rowname= {"点击id","课程id","点击量"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                Dianji qy= new Dianji();
                qy=list1.get(i);
                objs=new Object[rowname.length];
                objs[0]=qy.getDianjiid();
                objs[1]=qy.getKechengid();
                objs[2]=qy.getKechengdianjiliang();

                arrobj.add(objs);
            }

            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
}


    @RequestMapping(value="queryguanggaogg")
    @ResponseBody
    public String DataServices(HttpServletResponse  response) {
        List<GuangGaoBiao> list1 = WychaoServiceL.queryguang();
        String path="E:\\guanggao.xls";
        try {
            String title="广告表";
            String [] rowname= {"广告id","广告费","广告人","广告时间","广告类型","广告人","广告地址"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                GuangGaoBiao gg= new GuangGaoBiao();
                gg=list1.get(i);
                objs=new Object[rowname.length];
                objs[0] =gg.getGuanggaoid();
                objs[1]=gg.getMoney();
                objs[2]=gg.getGuanggaoname();
                objs[3]=gg.getGuanggaodate();
                objs[4]=gg.getZhanshistatus();
                objs[5]=gg.getChuliren();
                objs[6]=gg.getGuanggaophoto();
                arrobj.add(objs);
            }

            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
    }










    @RequestMapping(value="querykecheng")
    @ResponseBody


    public String DataServicess(HttpServletResponse  response) {
        List<KeCheng> list1 = WychaoServiceL.querykeCheng();
        String path="E:\\kengcheng.xls";
        try {
            String title="课程表";
            String [] rowname= {"序号","价格","数量","地址","名字","类型","状态"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                KeCheng kc= new KeCheng();
                kc=list1.get(i);
                objs=new Object[rowname.length];
                objs[0]= kc.getKechengid();
                objs[1]= kc.getKechengprice();
                objs[2]= kc.getShenhestatus();
                objs[3]=  kc.getHuiyuanstatus();
                objs[4]= kc.getHuiyuan();
                objs[5]= kc.getKechengphoto();
                objs[6]= kc.getKechengjieshao();
                objs[7]= kc.getHuiyuanstatus();



                arrobj.add(objs);
            }

            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
    }


    @RequestMapping(value="querygoumaigg")
    @ResponseBody
    public String DataServicesss(HttpServletResponse  response) {
        List<GouMaiBiao> list1 = WychaoServiceL.queryGouMaiBiao();
        String path="E:\\goumai.xls";
        try {
            String title="购买表";
            String [] rowname= {"购买","用户","课程", "数量","时间"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                GouMaiBiao gm= new GouMaiBiao();
                gm=list1.get(i);
                objs=new Object[rowname.length];
                objs[0]=   gm.getGoumaiid();
                objs[1]=  gm.getKechengid();
                objs[2]=  gm.getYonghuid();
                objs[3]= gm.getGoumaishuliang();
                objs[4]=  gm.getGoumaidate();

                arrobj.add(objs);
            }

            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
    }





}



