package com.jk.mapper.wjyi;

import com.jk.model.Power;
import com.jk.model.Role;
import com.jk.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IWjyiMapper {
    @Select("select id,text,pid,url from t_power")
    List<Power> queryTree();

    @Select("select count(*) from t_user")
    long countuser(User user);

    @Select("select * from t_user")
    List<User> queryuser();

    @Insert("insert into t_user values(#{userid},#{text},#{pid},#{password}，#{userstatus})")
    void adduser(User user);

    @Delete("delete from t_user where userid in (#{userid})")
    void deleteuser(@Param("userid") String userid);

    @Select("select * from t_user where userid=#{userid}")
    User queryById(@Param("userid") String userid);

    @Update("update t_user set userid=#{userid},text=#{text},pid=#{pid},password=#{password}，userstatus=#{userstatus} where userid=#{userid}")
    void updateuser(User user);

    @Select("select   *  from   t_role")
    List<Role> queryrole();

    @Select("select * from t_role t1,t_user_role t2  where t1.roleid=t2.roleid and t2.userid=#{userid}")
    List<Role> queryrolebyuserid(@Param("userid")String userid);

    @Delete("delete from t_user_role where userid=#{userids}")
    void deleteRoleAndUser(@Param("userids")String userids);

    @Insert("insert into t_user_role values\n" +
            "\t<foreach collection=\"arrayList\" item=\"ww\" separator=\",\">\n" +
            "\t(#{ww.userids},#{ww.roleids})\n" +
            "\t</foreach>")
    void addRoleAndUserid(@Param("arrayList") List<Map<String, String>> arrayList);
}
