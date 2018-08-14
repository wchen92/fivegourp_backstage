package com.jk.mapper.wjyi;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IWjyiMapper {

    //权限树查询  不同用户登录展示不同权限
    @Select("select t3.id,t3.text,t3.pid,t3.url from  t_user_role t1, t_role_power t2,t_power t3 where t1.roleid = t2.roleid and t2.id = t3.id and t1.userid = #{userid2} GROUP BY  t3.text")
    List<Power> queryTree(@Param("userid2") String userid2);

    //用户总数量查询
    @Select("select count(*) from t_user")
    long countuser(User user);

    //用户查询加条件查
    @Select("select * from t_user where 1=1 and text like '%${user.text}%' limit #{start},#{rows}")
    List<User> queryuser(@Param("start")int start, @Param("rows")int rows,@Param("user") User user);

    //用户新增
    @Insert("insert into t_user(userid,text,password,userstatus) values(#{userid},#{text},#{password},#{userstatus})")
    void adduser(User user);

    //用户删除
    @Delete("delete from t_user where userid in (#{userid})")
    void deleteuser(@Param("userid") String userid);

    //用户修改回显
    @Select("select * from t_user where userid=#{userid}")
    User queryById(@Param("userid") String userid);

    //用户修改
    @Update("update t_user set userid=#{userid},text=#{text},password=#{password},userstatus=2 where userid=#{userid}")
    void updateuser(User user);

    //所有角色查询
    @Select("select * from t_role")
    List<Role> queryrole();

    //根据用户id查询拥有角色
    @Select("select * from t_role t1,t_user_role t2  where t1.roleid=t2.roleid and t2.userid=#{userid}")
    List<Role> queryrolebyuserid(@Param("userid")String userid);

    //赋角色时删除
    @Delete("delete from t_user_role where userid=#{userids}")
    void deleteRoleAndUser(@Param("userids")String userids);

    //用户赋角色
    @Insert("insert into t_user_role values(#{userids},#{s})")
    void addRoleAndUserid(@Param("userids") String userids, @Param("s") String s);

    //角色查询加条件查
    @Select("select * from t_role where 1=1 and text like '%${role.text}%' limit #{start},#{rows}")
    List<Role> queryRole(@Param("start") int start, @Param("rows")int rows, @Param("role")Role role);

    //角色总数量查询
    @Select("select count(*) from t_role")
    long countRole(Role role);

    //角色新增
    @Insert("insert into t_role(roleid,text) values(#{roleid},#{text})")
    void addRole(Role role);

    //角色修改回显
    @Select("select * from t_role where roleid=#{roleid}")
    Role queryRoleById(@Param("roleid") String roleid);

    //角色修改
    @Update("update t_role set roleid=#{roleid},pid=#{pid},text=#{text} where roleid=#{roleid}")
    void updateRole(Role role);

    //角色删除
    @Delete("delete from t_role where roleid in (#{roleid})")
    void deleteRole(@Param("roleid")String roleid);

    //权限查询加条件查
    @Select("select t.id,t.text,t.pid from t_power t where 1=1 and t.text like '%${power.text}%' group by t.text limit #{start},#{rows}")
    List<Power> queryPower(@Param("start") int start, @Param("rows") int rows, @Param("power") Power power);

    //权限总数量查询
    @Select("select count(*) from t_power")
    long countPower(Power power);

    //权限新增
    @Insert("insert into t_power(id,text,pid) values(#{id},#{text},#{pid})")
    void addPower(Power power);

    //权限修改回显
    @Select("select p.id,p.text,p.pid from t_power p where id=#{id}")
    Power queryPowerById(@Param("id") String id);

    //权限修改
    @Update("update t_power set id=#{id},text=#{text},pid=#{pid} where id=#{id}")
    void updatePower(Power power);

    //权限删除
    @Delete("delete from t_power where id in (#{id})")
    void deletePower(@Param("id")String id);

    //查询所有权限
    @Select("select * from t_power")
    List<Power> queryPowerAll();

    //没用到的方法（根据用户展示权限）
    @Select("select * from t_power t1,t_role_power t2,t_user_role t3  where t1.id=t2.id and t3.roleid=t2.roleid and t3.userid=#{userid} and t2.roleid=#{roleid}")
    List<Power> queryRoleAndPower(@Param("roleid")String roleid,@Param("userid") String userid);

    //赋权限时先删除所拥有权限
    @Delete("delete from t_role_power where roleid=#{roleids}")
    void deletePowerAndRole(@Param("roleids") String roleids);

    //赋权限
    @Insert("insert into t_role_power values (#{roleids},#{s})")
    void addPowerAndRoleid(@Param("roleids") String roleids, @Param("s")String s);

    //用户状态为未审核的查询
    @Select("select * from t_user t where t.userstatus=2 limit #{start},#{rows}")
    List<User> shenheuser(@Param("start") int start, @Param("rows")int rows, @Param("user")User user);

    //用户状态为未审核的总数
    @Select("select count(*) from t_user")
    long countShenheUser(User user);

    //修改用户状态 未审核到已审核
    @Update("update t_user set userstatus=1 where userid = #{userid}")
    void piliangquerenuserid(@Param("userid") String userid);

    //查询课程状态为未审核的信息
    @Select("select * from kecheng t where shenhestatus=2 limit #{start},#{rows}")
    List<KeCheng> querywjyKeCheng(@Param("start")int start, @Param("rows")int rows,@Param("keCheng") KeCheng keCheng);

    //查询课程状态为未审核的信息总数
    @Select("select count(*) from kecheng")
    long countwjyKeCheng(KeCheng keCheng);

    //修改课程状态 未审核为已审核
    @Update("update kecheng set shenhestatus=1 where kechengid = #{kechengid}")
    void piliangQuerenKecheng(@Param("kechengid") String kechengid);

    //查询广告位状态为未审核的信息
    @Select("select * from guanggaobiao t where zhanshistatus=2 limit #{start},#{rows}")
    List<GuangGaoBiao> querywjyGuang(@Param("start")int start, @Param("rows")int rows,@Param("guangGaoBiao") GuangGaoBiao guangGaoBiao);

    //查询广告位状态为未审核的信息总数
    @Select("select count(*) from guanggaobiao")
    long countwjyGuang(GuangGaoBiao guangGaoBiao);

    //修改广告位状态 未审核为已审核
    @Update("update guanggaobiao set zhanshistatus=1 where guanggaoid = #{guanggaoid}")
    void piliangQuerenGuanggao(@Param("guanggaoid") String guanggaoid);

    //下拉树
    @Select("select id,text,pid from t_power")
    List<Power> queryComboPower();

    //根据角色id查询权限
    @Select("select * from t_role_power t1,t_power t2 where t1.id=t2.id and roleid=#{roleid}")
    List<Power> queryRoleAndPowers(@Param("roleid") String roleid);
}
