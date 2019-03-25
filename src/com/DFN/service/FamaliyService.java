package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableFamaliyEntity;
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
public class FamaliyService {
    @RequestMapping(value = "/addFamaliy",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addFamaliy(String famaliyName, String famaliyInfo) {

        TableFamaliyEntity famaliyEntity = new TableFamaliyEntity();
        famaliyEntity.setFamaliyName(famaliyName);
        famaliyEntity.setFamaliyInfo(famaliyInfo);


        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(famaliyEntity);

        tx.commit();
    }

    @RequestMapping(value = "/delFamaliy",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delFamaliy(int famaliyId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableFamaliyEntity.class, famaliyId);

        tx.commit();
    }

    @RequestMapping(value = "/delAllFamaliy",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAllFamaliy() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableFamaliyEntity.class);

        tx.commit();
    }


    @RequestMapping(value = "/getAllFamaliy",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String getAllFamaliy() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableFamaliyEntity.class);

        tx.commit();

        List<TableFamaliyEntity> TableFamaliyEntityList = new ArrayList<TableFamaliyEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableFamaliyEntityList.add(i, (TableFamaliyEntity) resultList.get(i));
            System.out.println("值：" + (TableFamaliyEntityList.get(i)).getFamaliyName());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping(value = "/updateFamaliy",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updateFamaliy(int famaliyId, String famaliyName, String famaliyInfo) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableFamaliyEntity result = baseDao.get(TableFamaliyEntity.class, famaliyId);


        if (result != null) {


            TableFamaliyEntity famaliyEntity = new TableFamaliyEntity();

            famaliyEntity.setFamaliyId(famaliyId);
            famaliyEntity.setFamaliyName(famaliyName);
            famaliyEntity.setFamaliyInfo(famaliyInfo);


            baseDao.update(famaliyEntity);

        } else {
            return "{\"res\":\"家庭不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
