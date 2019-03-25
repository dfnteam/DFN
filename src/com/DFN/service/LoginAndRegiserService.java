package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableUserEntity;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
public class LoginAndRegiserService {


    @RequestMapping(value = "/login", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
    @ResponseBody
    public String login(int userId, String password) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();

        TableUserEntity result= baseDao.get(TableUserEntity.class,userId);
//        List listResult =baseDao.getListBySQL("SELECT * FROM table_user WHERE user_id="+userId+" and user_password="+password,TableUserEntity.class);




        tx.commit();

        if (result != null) {
            if (result.getUserPassword().equals(password)) {
                ToJosn toJosn = new ToJosn();

                String jsonData = toJosn.ClassToJson(result);
                return jsonData;
            } else {
                return "{\"res\":\"密码错误\"}";
            }


        } else {
            return "{\"res\":\"用户不存在\"}";
        }

    }

    @RequestMapping(value = "/register", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
    @ResponseBody
    public String register(String name, String password, String QQstring, String mail, String type,String sex,String birthday) throws ParseException {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        UserService userService = new UserService();
        userService.addUser(name, password, QQstring, mail, type,sex, birthday);

        BaseDaoImpl baseDao = new BaseDaoImpl();
        List listResult = baseDao.getAll(TableUserEntity.class);
        tx.commit();

        for (int i = 0; i < listResult.size(); i++) {

            TableUserEntity tableUserEntity = (TableUserEntity) listResult.get(i);


            if (tableUserEntity.getUserName().equals(name) && tableUserEntity.getUserPassword().equals(password)) {

                ToJosn toJosn = new ToJosn();
                String jsonData = toJosn.ClassToJson(tableUserEntity);

                return jsonData;

            }
        }
        return "{\"res\":\"error\"}";
    }

}
