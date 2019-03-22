package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableUserEntity;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserService {
    //增加user
    /*@CrossOrigin*/
    @RequestMapping("/addUser")
    public void addUser(String name, String password, int QQ, String mail, String type) {

        String nickname = "DFN-user";

        int user_type = 0;

        if ("爸爸".equals(type)) {
            user_type = 1;
        } else if ("妈妈".equals(type)) {
            user_type = 2;
        } else if ("儿子".equals(type)) {
            user_type = 3;
        } else if ("女儿".equals(type)) {
            user_type = 4;
        }

        TableUserEntity userEntity = new TableUserEntity();
        userEntity.setUserName(name);
        userEntity.setUserMail(mail);
        userEntity.setUserNickname(nickname);
        userEntity.setUserPassword(password);
        userEntity.setUserQq(QQ);
        userEntity.setUserType(user_type);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(userEntity);

        tx.commit();
    }


    //删除user
    @RequestMapping("/delUser")
    public void delUser(int userid) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableUserEntity.class, userid);

        tx.commit();

    }

    //删除全部user
    @RequestMapping("/deleteAllUser")
    public void deleteAllUser() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableUserEntity.class);

        tx.commit();
    }

    //查询所有user
    @RequestMapping("/getAllUser")
    @ResponseBody
    public String getAllUser() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableUserEntity.class);

        tx.commit();

        List<TableUserEntity> TableUserEntityList = new ArrayList<TableUserEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableUserEntityList.add(i, (TableUserEntity) resultList.get(i));
            System.out.println("值：" + (TableUserEntityList.get(i)).getUserName());
        }

        System.out.println("长度：" + resultList.size());

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }


    //更新user
    @RequestMapping("/updateUser")
    public String updateUser(int userid, String name, String nickname, String password, int QQ, String mail, String type) {
        int user_type = 0;

        if ("爸爸".equals(type)) {
            user_type = 1;
        } else if ("妈妈".equals(type)) {
            user_type = 2;
        } else if ("儿子".equals(type)) {
            user_type = 3;
        } else if ("女儿".equals(type)) {
            user_type = 4;
        }

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableUserEntity result = baseDao.get(TableUserEntity.class, userid);


        if (result != null) {


            TableUserEntity userEntity = new TableUserEntity();
            userEntity.setUserId(userid);
            userEntity.setUserName(name);
            userEntity.setUserMail(mail);
            userEntity.setUserNickname(nickname);
            userEntity.setUserPassword(password);
            userEntity.setUserQq(QQ);
            userEntity.setUserType(user_type);

            baseDao.update(userEntity);

        } else {
            return "{\"res\":\"用户不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";
    }


}
