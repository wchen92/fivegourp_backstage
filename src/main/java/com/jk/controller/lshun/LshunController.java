package com.jk.controller.lshun;

import com.jk.service.lshun.ILshunService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:23
 * @ Description：
 * @ Version:
 */
@RestController
@RequestMapping("liushun")
public class LshunController {
    @Resource
    private ILshunService LshunService;
}
