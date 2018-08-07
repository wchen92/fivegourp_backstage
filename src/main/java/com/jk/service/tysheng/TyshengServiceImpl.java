package com.jk.service.tysheng;

import com.jk.mapper.tysheng.ITyshengMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
