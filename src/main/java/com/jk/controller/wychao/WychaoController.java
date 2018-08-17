package com.jk.controller.wychao;

import com.alibaba.fastjson.JSON;

import com.jk.model.Dianji;
import com.jk.model.GouMaiBiao;
import com.jk.model.GuangGaoBiao;
import com.jk.model.KeCheng;
import com.jk.service.wychao.IWychaoService;
import com.jk.uitl.wyc.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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



    //poi导表
    @RequestMapping(value="/exportExcel")

    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SXSSFWorkbook workbook = new SXSSFWorkbook(5000);
        //每页条数
        int rows = 2;
        int totalPage = 0;
        //传参数
        Dianji news = new Dianji();
        //查询总条数
        Integer count = WychaoServiceL.getProductCount();
        //计算总页数
        totalPage =  count%rows==0?count/rows:count/rows+1;
        System.out.println("总共"+totalPage+"页");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= totalPage; i++) {
            news = new Dianji();
            news.setPage((i-1)*rows);
            news.setRows(rows);
            cachedThreadPool.execute(new CreateExcel(WychaoServiceL,workbook,news));
        }
        cachedThreadPool.shutdown();

        boolean loop = true;
        do {    //等待所有任务完成
            loop = !cachedThreadPool.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
        } while(loop);

        System.out.println(request.getRealPath("/"));
        String filePath = request.getRealPath("/")+new Date().getTime()+".xlsx";
        OutputStream out = new FileOutputStream(new File(filePath));
        workbook.write(out);
        out.flush();
        out.close();
        workbook.dispose();
        FileUtil.downloadFile(request, response, filePath, "新闻信息表.xlsx");
        new File(filePath).delete();
    }

    //poi导表
    @RequestMapping(value="/Excel")

    public void Excel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SXSSFWorkbook xxbook = new SXSSFWorkbook(5000);
        //每页条数
        int rows = 2;
        int totalPage = 0;
        //传参数
        GouMaiBiao gg = new GouMaiBiao();
        //查询总条数
        Integer count = WychaoServiceL.getGouMaiBiaoCount();
        //计算总页数
        totalPage =  count%rows==0?count/rows:count/rows+1;
        System.out.println("总共"+totalPage+"页");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= totalPage; i++) {
            gg = new GouMaiBiao();
            gg.setPage((i-1)*rows);
            gg.setRows(rows);
            cachedThreadPool.execute(new GoumaiExcel(WychaoServiceL,xxbook,gg));
        }
        cachedThreadPool.shutdown();

        boolean loop = true;
        do {    //等待所有任务完成
            loop = !cachedThreadPool.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
        } while(loop);

        System.out.println(request.getRealPath("/"));
        String filePath = request.getRealPath("/")+new Date().getTime()+".xlsx";
        OutputStream out = new FileOutputStream(new File(filePath));
        xxbook.write(out);
        out.flush();
        out.close();
        xxbook.dispose();
        FileUtil.downloadFile(request, response, filePath, "新闻信息表ss.xlsx");
        new File(filePath).delete();
    }


    //poi导表
    @RequestMapping(value="/guanggaoExcel")

    public void guanggaoExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SXSSFWorkbook xxbook = new SXSSFWorkbook(5000);
        //每页条数
        int rows = 2;
        int totalPage = 0;
        //传参数
        GuangGaoBiao gg = new GuangGaoBiao();
        //查询总条数
        Integer count = WychaoServiceL.getGuangGaoBiaoCount();
        //计算总页数
        totalPage =  count%rows==0?count/rows:count/rows+1;
        System.out.println("总共"+totalPage+"页");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= totalPage; i++) {
            gg = new GuangGaoBiao();
            gg.setPage((i-1)*rows);
            gg.setRows(rows);
            cachedThreadPool.execute(new GuanggaoiExcel(WychaoServiceL,xxbook,gg));
        }
        cachedThreadPool.shutdown();

        boolean loop = true;
        do {    //等待所有任务完成
            loop = !cachedThreadPool.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
        } while(loop);

        System.out.println(request.getRealPath("/"));
        String filePath = request.getRealPath("/")+new Date().getTime()+".xlsx";
        OutputStream out = new FileOutputStream(new File(filePath));
        xxbook.write(out);
        out.flush();
        out.close();
        xxbook.dispose();
        FileUtil.downloadFile(request, response, filePath, "新闻信息表sss.xlsx");
        new File(filePath).delete();

    }


    @RequestMapping(value="/kechengExcel")

    public void kechengExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SXSSFWorkbook workbook = new SXSSFWorkbook(5000);
        //每页条数
        int rows = 2;
        int totalPage = 0;
        //传参数
        KeCheng news = new KeCheng();
        //查询总条数
        Integer count = WychaoServiceL.getkechengCount();
        //计算总页数
        totalPage =  count%rows==0?count/rows:count/rows+1;
        System.out.println("总共"+totalPage+"页");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= totalPage; i++) {
            news = new KeCheng();
            news.setPage((i-1)*rows);
            news.setRows(rows);
            cachedThreadPool.execute(new kechengExcel(WychaoServiceL,workbook,news));
        }
        cachedThreadPool.shutdown();

        boolean loop = true;
        do {    //等待所有任务完成
            loop = !cachedThreadPool.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
        } while(loop);

        System.out.println(request.getRealPath("/"));
        String filePath = request.getRealPath("/")+new Date().getTime()+".xlsx";
        OutputStream out = new FileOutputStream(new File(filePath));
        workbook.write(out);
        out.flush();
        out.close();
        workbook.dispose();
        FileUtil.downloadFile(request, response, filePath, "新闻信息表xx.xlsx");
        new File(filePath).delete();
    }





}



