package com.DFN.controller;

import com.DFN.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ViewAllcoacherController {


    @RequestMapping("/viewAllCoacher")

    @ResponseBody
    public List viewAllCoacher(){
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        String hqlString2 = "from CoacherEntity";
        Query query1 = session.createQuery(hqlString2);
        List resultList = query1.getResultList();

        tx.commit();
//        List<CoacherEntity> coacherEntity = null;
//
//        for (int i = 0; i < resultList.size(); i++) {
//
//            coacherEntity.add(i, ((CoacherEntity) resultList.get(i)));
//        }

        return resultList;
    }
}
