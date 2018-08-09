package com.jk.mapper.wjyi;

import com.jk.model.Power;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IWjyiMapper {
    @Select("select id,text,pid,url from t_power")
    List<Power> queryTree();
}
