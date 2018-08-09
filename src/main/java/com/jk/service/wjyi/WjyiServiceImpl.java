package com.jk.service.wjyi;

import com.jk.mapper.wjyi.IWjyiMapper;
import com.jk.model.Power;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/7 19:31
 * @ Description：
 * @ Version:
 */
@Service
public class WjyiServiceImpl implements  IWjyiService{
    @Resource
    private IWjyiMapper WjyiMapper;

    @Override
    public List<Power> queryTree() {
        return WjyiMapper.queryTree();
    }
}
