package com.jk.controller.wychao;

import com.alibaba.fastjson.JSON;

import com.jk.service.wychao.IWychaoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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




    }



