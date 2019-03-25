package com.DFN.test;

import com.DFN.entity.TableAlbumEntity;
import com.DFN.entity.TableUserEntity;
import com.DFN.service.LoginAndRegiserService;
import com.DFN.service.ShareService;
import com.DFN.service.UserService;
import com.DFN.util.GetDate;
import com.DFN.util.HibernateUtil;
import com.DFN.util.IntToString;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        //-----------1-------
//        Session session = HibernateUtil.getSessionobject();
//        Transaction tx = session.beginTransaction();
//
//        String hqlString2 = "from TableUserEntity";
//        Query query1 = session.createQuery(hqlString2);
//        List resultList = query1.getResultList();
//
//        tx.commit();
//        List<TableUserEntity> list = null;
//
//        list.set(1, (TableUserEntity)resultList.get(0) );
//
//       String  s= list.get(1).toString();


      //---------2--------list add功能 初始化容器为10
//        List<String> list= new ArrayList<String>(10);
//        list.add(0,"asda");
//       String s=list.get(0);
//       System.out.println(s);

      //------------3---------user显示功能测试
//        UserService userService=new UserService();
//        userService.getAllUser();

        //-----------4-------user添加功能测试

//        UserService userService=new UserService();
//        userService.addUser("秦羚健","456ads",15798459,"qinglingjian@qq.com","爸爸");
        //---------5-----------getDate获取时间测试
//        GetDate getDate=new GetDate();
//        getDate.getDate();
//        System.out.println(getDate.getDate());
        //----------6----------addDate到数据库
//        ShareService shareService =new ShareService();
//        shareService.addShare("美美的一天","今天天气真好啊");
        //---------7---------获取时间datetime
//        ShareService shareService =new ShareService();
//        String s=shareService.getAllShare();
//        System.out.println(s);


        //--------------8--------------
//        LoginAndRegiserService service=new LoginAndRegiserService();
//        String s=service.login(1,"123456");
//
//        System.out.println(s);

        IntToString intToString=new IntToString();

        int i=  intToString.stringToInt("");
        System.out.println(i);

    }


}
