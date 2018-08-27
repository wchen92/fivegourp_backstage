package com.jk.service.wjyi;

import com.jk.model.*;

import java.util.List;
import java.util.Map;

public interface IWjyiService {
    List<Power> queryTree(String userid2);

    /*List<User> queryuser(int page,int rows,User user);*/
    Map<String,Object> queryuser(int page, int rows, User user);

    void adduser(User user);

    void deleteuser(String userid);

    User queryById(String userid);

    void updateuser(User user);

    List<Role> queryrole();

    List<Role> queryrolebyuserid(String userid);

    void addRoleAndUserid(String userids, String roleids);


    Map<String,Object> queryRole(int page, int rows, Role role);

    void addRole(Role role);

    Role queryRoleById(String roleid);

    void updateRole(Role role);

    void deleteRole(String roleid);

    Map<String,Object> queryPower(int page, int rows, Power power);

    void addPower(Power power);

    Power queryPowerById(String id);

    void updatePower(Power power);

    void deletePower(String id);

    List<Power> queryPowerAll();

    List<Power> queryRoleAndPower(String roleid, String userid);

    void addPowerAndRoleid(String roleids, String quanids);

    Map<String,Object> shenheuser(int page, int rows, User user);

    void piliangquerenuserid(String userid);

    Map<String,Object> querywjyKeCheng(int page, int rows, KeCheng keCheng);

    void piliangQuerenKecheng(String kechengid);

    Map<String,Object> querywjyGuang(int page, int rows, GuangGaoBiao guangGaoBiao);

    void piliangQuerenGuanggao(String guanggaoid);

    List<Power> queryComboPower();

    List<Power> queryRoleAndPowers(String roleid);

    Map<String,Object> queryRenwu(int page, int rows, RenWu renwu);

    Map<String,Object> queryZhipai(int page, int rows, ZhiPai zhipai,String uid );

    Map<String,Object> queryRenwuAll(int page, int rows, RenWu renwu);

    List<User> queryComboUser();

    void fabuRenwu(RenWu renwu, String usid);

    void fabuZhipaiRenwu(RenWu renwu,ZhiPai zhiPai,String usid);

    void updateWanchengStatus(String rwid, String usids );

    Integer queryWeiwanchengShu();

    Integer queryZhipaiShu(String us );

    void updateZhiWanchengstatus(String rwid, String usid);

    Map<String,Object> login(QianTaiYongHu people);

    QianTaiYongHu queryYongHuByName(String yonghuname);

    void saveYongHu(QianTaiYongHu yonghu);

    void updatexinxi(QianTaiYongHu qiantaiyonghu);

    List<QianTaiYongHu> queryAllxinxi(String us);

    void updatemima(QianTaiYongHu qiantaiyonghu);

    QianTaiYongHu wchenselectoftouser(String yonghuid);
}
