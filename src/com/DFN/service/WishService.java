package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableUserEntity;
import com.DFN.entity.TableWishEntity;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
@CrossOrigin
public class WishService {
    @RequestMapping(value = "/addWish",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addWish(String wishName, int wishPublic, int state) {
        TableWishEntity wishEntity = new TableWishEntity();

        wishEntity.setWishName(wishName);
        wishEntity.setWishPublic(wishPublic);
        wishEntity.setWishState(0);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(wishEntity);

        tx.commit();
    }

    @RequestMapping(value = "/delWish",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delWish(int wishId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableWishEntity.class, wishId);

        tx.commit();
    }

    @RequestMapping(value = "/delAllWish",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAllWish() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableWishEntity.class);

        tx.commit();
    }


    @RequestMapping(value = "/getAllWish",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String getAllWish() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableWishEntity.class);

        tx.commit();

        List<TableWishEntity> TableWishEntityList = new ArrayList<TableWishEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableWishEntityList.add(i, (TableWishEntity) resultList.get(i));
            System.out.println("值：" + (TableWishEntityList.get(i)).getWishName());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping(value = "/updateWish",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updateWish(int wishId, String wishNama, int wishpublic, int state) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableWishEntity result = baseDao.get(TableWishEntity.class, wishId);

        if (result != null) {
            TableWishEntity wishEntity = new TableWishEntity();
            wishEntity.setWishId(wishId);
            wishEntity.setWishName(wishNama);
            wishEntity.setWishPublic(wishpublic);
            wishEntity.setWishState(0);


            baseDao.update(wishEntity);

        } else {
            return "{\"res\":\"心愿不存在\"}";

        }
        tx.commit();
        return "{\"res\":\"更改成功\"}";
    }
}
