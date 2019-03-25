package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableUserEntity;
import com.DFN.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
@Controller
@CrossOrigin
public class UserService {
    //增加user
    @RequestMapping(value = "/addUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addUser(String name, String password, String QQstring, String mail, String type,String sex,String birthday) throws ParseException {
        IntToString intToString=new IntToString();
        int QQ= intToString.stringToInt(QQstring);

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

        userEntity.setUserSex(sex);
        StrToDate strToDate=new StrToDate();
        Timestamp timestamp=strToDate.strToTimestamp(birthday);
        userEntity.setUserBirthday(timestamp);

        userEntity.setUserQq(QQ);
        userEntity.setUserType(user_type);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(userEntity);

        tx.commit();
    }


    //删除user
    @RequestMapping(value = "/delUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delUser(int userId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableUserEntity.class, userId);

        tx.commit();

    }

    //删除全部user
    @RequestMapping(value = "/deleteAllUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void deleteAllUser() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableUserEntity.class);

        tx.commit();
    }

    //查询所有user
    @RequestMapping(value = "/getAllUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
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
    @RequestMapping(value = "/updateUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updateUser(int userId, String name, String nickname, String password, String QQstring, String mail, String type,String sex,String birthday) throws ParseException {
        IntToString intToString=new IntToString();
        int QQ= intToString.stringToInt(QQstring);

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
        TableUserEntity result = baseDao.get(TableUserEntity.class, userId);


        if (result != null) {


            TableUserEntity userEntity = new TableUserEntity();
            userEntity.setUserId(userId);
            userEntity.setUserName(name);
            userEntity.setUserMail(mail);
            userEntity.setUserNickname(nickname);
            userEntity.setUserPassword(password);
            userEntity.setUserSex(sex);
            StrToDate strToDate=new StrToDate();
            Timestamp timestamp=strToDate.strToTimestamp(birthday);
            userEntity.setUserBirthday(timestamp);
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
