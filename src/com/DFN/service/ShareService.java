package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableShareEntity;
import com.DFN.util.GetDate;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Controller
@CrossOrigin
public class ShareService {
    @RequestMapping(value = "/addShare",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addShare(String shareName, String shareContent) {


        TableShareEntity shareEntity = new TableShareEntity();
        shareEntity.setShareName(shareName);
        shareEntity.setShareContent(shareContent);
        GetDate getDate = new GetDate();
        Timestamp datetime = getDate.getDate();
        shareEntity.setShareDate(datetime);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(shareEntity);

        tx.commit();
    }

    @RequestMapping(value = "/delShare",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delShare(int ShareId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableShareEntity.class, ShareId);

        tx.commit();
    }

    @RequestMapping(value = "/delAllShare",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAllShare() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableShareEntity.class);

        tx.commit();
    }


    @RequestMapping(value = "/getAllShare",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String getAllShare() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableShareEntity.class);

        tx.commit();

        List<TableShareEntity> TableShareEntityList = new ArrayList<TableShareEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableShareEntityList.add(i, (TableShareEntity) resultList.get(i));
            System.out.println("值：" + (TableShareEntityList.get(i)).getShareName());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping(value = "/updateShare",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updateShare(int shareId, String shareName, String shareContent) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableShareEntity result = baseDao.get(TableShareEntity.class, shareId);


        if (result != null) {


            TableShareEntity shareEntity = new TableShareEntity();
            shareEntity.setShareId(shareId);
            shareEntity.setShareName(shareName);
            shareEntity.setShareContent(shareContent);
            GetDate getDate = new GetDate();
            Timestamp datetime = getDate.getDate();
            shareEntity.setShareDate(datetime);
            baseDao.update(shareEntity);

        } else {
            return "{\"res\":\"分享不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
