package com.jk.service.wychao;

import com.jk.mapper.wychao.IWychaoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:31
 * @ Description：
 * @ Version:
 */
@Service
public class WychaoServiceImpl implements IWychaoService{
    @Resource
    private IWychaoMapper WychaoMapper;
}
