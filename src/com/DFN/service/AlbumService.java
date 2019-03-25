package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableAlbumEntity;
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
public class AlbumService {
    @RequestMapping(value = "/addAlbum",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void addAlbum(String albumName) {


        TableAlbumEntity albumEntity = new TableAlbumEntity();
        albumEntity.setAlbumName(albumName);
        GetDate getDate = new GetDate();
        Timestamp datetime = getDate.getDate();
        albumEntity.setAlbumDate(datetime);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(albumEntity);

        tx.commit();
    }

    @RequestMapping(value = "/delAlbum",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAlbum(int albumId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableAlbumEntity.class, albumId);

        tx.commit();
    }

    @RequestMapping(value = "/delAllAlbum",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public void delAllAlbum() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableAlbumEntity.class);

        tx.commit();
    }


    @RequestMapping(value = "/getAllAlbum",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String getAllAlbum() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableAlbumEntity.class);

        tx.commit();

        List<TableAlbumEntity> TableAlbumEntityList = new ArrayList<TableAlbumEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableAlbumEntityList.add(i, (TableAlbumEntity) resultList.get(i));
            System.out.println("值：" + (TableAlbumEntityList.get(i)).getAlbumName());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping(value = "/updateAlbum",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    @ResponseBody
    public String updateAlbum(int albumId, String albumName) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableAlbumEntity result = baseDao.get(TableAlbumEntity.class, albumId);


        if (result != null) {

            TableAlbumEntity albumEntity = new TableAlbumEntity();
            albumEntity.setAlbumId(albumId);
            albumEntity.setAlbumName(albumName);
            GetDate getDate = new GetDate();
            Timestamp datetime = getDate.getDate();
            albumEntity.setAlbumDate(datetime);

            baseDao.update(albumEntity);

        } else {
            return "{\"res\":\"相册不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
