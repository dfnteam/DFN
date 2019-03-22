package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableBillEntity;
import com.DFN.util.GetDate;
import com.DFN.util.HibernateUtil;
import com.DFN.util.ToJosn;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Controller
public class BillService {
    @RequestMapping("/addBill")
    public void addBill(String billGoods, int billPrice) {


        TableBillEntity billEntity = new TableBillEntity();
        billEntity.setBillGoods(billGoods);
        billEntity.setBillPrice(billPrice);
        GetDate getDate = new GetDate();
        Timestamp datetime = getDate.getDate();
        billEntity.setBillDate(datetime);

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.save(billEntity);

        tx.commit();
    }

    @RequestMapping("/delBill")
    public void delBill(int billId) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteById(TableBillEntity.class, billId);

        tx.commit();
    }

    @RequestMapping("/delAllBill")
    public void delAllBill() {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        BaseDaoImpl baseDao = new BaseDaoImpl();
        baseDao.deleteAll(TableBillEntity.class);

        tx.commit();
    }


    @RequestMapping("/getAllBill")
    public String getAllBill() {

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        List resultList = baseDao.getAll(TableBillEntity.class);

        tx.commit();

        List<TableBillEntity> TableBillEntityList = new ArrayList<TableBillEntity>();

        for (int i = 0; i < resultList.size(); i++) {

            TableBillEntityList.add(i, (TableBillEntity) resultList.get(i));
            System.out.println("值：" + (TableBillEntityList.get(i)).getBillGoods());
        }

        ToJosn toJosn = new ToJosn();

        String jsonData = toJosn.ClassToJson(resultList);

        return jsonData;

    }

    @RequestMapping("/updateBill")
    public String updateBill(int billId, String billGoods, int billPrice) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();


        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableBillEntity result = baseDao.get(TableBillEntity.class, billId);


        if (result != null) {


            TableBillEntity billEntity = new TableBillEntity();
            billEntity.setBillId(billId);
            billEntity.setBillGoods(billGoods);
            billEntity.setBillPrice(billPrice);
            GetDate getDate = new GetDate();
            Timestamp datetime = getDate.getDate();
            billEntity.setBillDate(datetime);

            baseDao.update(billEntity);

        } else {
            return "{\"res\":\"账单不存在\"}";
        }

        tx.commit();
        return "{\"res\":\"更改成功\"}";

    }
}
