package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TablePasswordEntity;
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
@CrossOrigin
public class PasswordService {
    @RequestMapping(value = "/addPassword",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addPassword(String passwordName, String passwordContent) {


        TablePasswordEntity passwordEntity = new TablePasswordEntity();
        passwordEntity.setPasswordName(passwordName);
        passwordEntity.setPasswordContent(passwordContent);


        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(passwordEntity);

        tx.commit();
    }

    @RequestMapping(value = "/delPassword",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delPassword(int passwordId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TablePasswordEntity.class, passwordId);

        tx.commit();
    }

    @RequestMapping(value = "/delAllPassword",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAllPassword() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TablePasswordEntity.class);

        tx.commit();
    }


    @RequestMapping(value = "/getAllPassword",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String getAllPassword() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TablePasswordEntity.class);

        tx.commit();

        List<TablePasswordEntity> TablePasswordEntityList = new ArrayList<TablePasswordEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TablePasswordEntityList.add(i, (TablePasswordEntity) resultList.get(i));
            System.out.println("值：" + (TablePasswordEntityList.get(i)).getPasswordName());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping(value = "/updatePassword",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updatePassword(int passwordId, String passwordName, String passwordContent) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TablePasswordEntity result = baseDao.get(TablePasswordEntity.class, passwordId);


        if (result != null) {


            TablePasswordEntity passwordEntity = new TablePasswordEntity();
            passwordEntity.setPasswordId(passwordId);
            passwordEntity.setPasswordName(passwordName);
            passwordEntity.setPasswordContent(passwordContent);

            baseDao.update(passwordEntity);

        } else {
            return "{\"res\":\"密码本不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
