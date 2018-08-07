package com.jk.controller.tysheng;

import com.jk.service.tysheng.ITyshengService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
