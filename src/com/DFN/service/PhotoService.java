package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TablePhotoEntity;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PhotoService {
    @RequestMapping("/addPhoto")
    public void addPhoto(String photoAdress) {


        TablePhotoEntity photoEntity = new TablePhotoEntity();

        photoEntity.setPhotoAddress(photoAdress);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(photoEntity);

        tx.commit();
    }

    @RequestMapping("/delPhoto")
    public void delPhoto(int photoId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TablePhotoEntity.class, photoId);

        tx.commit();
    }

    @RequestMapping("/delAllPhoto")
    public void delAllPhoto() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TablePhotoEntity.class);

        tx.commit();
    }


    @RequestMapping("/getAllPhoto")
    public String getAllPhoto() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TablePhotoEntity.class);

        tx.commit();

        List<TablePhotoEntity> TablephotoEntityList = new ArrayList<TablePhotoEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TablephotoEntityList.add(i, (TablePhotoEntity) resultList.get(i));
            System.out.println("值：" + (TablephotoEntityList.get(i)).getPhotoAddress());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping("/updatePhoto")
    public String updatePhoto(int photoId, String photoAddress) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TablePhotoEntity result = baseDao.get(TablePhotoEntity.class, photoId);


        if (result != null) {


            TablePhotoEntity photoEntity = new TablePhotoEntity();
            photoEntity.setPhotoAlbumId(photoId);
            photoEntity.setPhotoAddress(photoAddress);
            baseDao.update(photoEntity);

        } else {
            return "{\"res\":\"图片不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
