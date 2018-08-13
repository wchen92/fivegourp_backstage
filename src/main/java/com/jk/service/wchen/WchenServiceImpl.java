package com.jk.service.wchen;

import com.jk.model.Log;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/10 15:20
 * @ Description：
 * @ Version:
 */
@Service
public class WchenServiceImpl implements IWchenService{
    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public Map<String,Object> selectlog(Integer page, Integer rows) {
        Query query = new Query();
        //skip 跳过  设置分页查询的起始位置
        query.skip((page-1)*rows);
        query.limit(rows);
        long count = mongoTemplate.count(new Query(),Log.class);
        List<Log> all = mongoTemplate.find(query,Log.class);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("total",count);
        stringObjectHashMap.put("rows",all);
        return stringObjectHashMap;
    }
}
