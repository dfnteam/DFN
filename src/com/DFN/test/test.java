package com.DFN.test;

import com.DFN.entity.TableUserEntity;
import com.DFN.util.HibernateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class test {


    public static void main(String[] args) {


 //Session session = HibernateUtil.getSession();

        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();

        String hqlString2 = "from TableUserEntity";
        Query query1 = session.createQuery(hqlString2);
        List resultList = query1.getResultList();

        tx.commit();
        List<TableUserEntity> TableUserEntityList =new  ArrayList<TableUserEntity>();


//        System.out.println("长度："+resultList.size()+"  ..."+((TableUserEntity)resultList.get(0)).getUserName());

        for (int i = 0; i < resultList.size(); i++) {

//            System.out.println(((TableUserEntity)resultList.get(i)).getUserName());

            TableUserEntityList.add(i,(TableUserEntity)resultList.get(i));

            System.out.println("值：" + (TableUserEntityList.get(i)).getUserName());
        }

        System.out.println("长度：" + resultList.size());


        //----------转json数据 测试
        JSONObject jsonObject = JSONObject.fromObject(TableUserEntityList.get(0));
        String name=jsonObject.getString("userName");
        String password=jsonObject.getString("userPassword");

        System.out.println("name:"+name+"\npassword:"+password);
        //s.close();
        System.out.print("\nend");
        System.out.println(JSONArray.fromObject(TableUserEntityList).toString());


    }


}
