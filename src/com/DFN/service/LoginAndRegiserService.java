package com.DFN.service;

import com.DFN.dao.impl.BaseDaoImpl;
import com.DFN.entity.TableUserEntity;
import com.DFN.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
@Controller
public class LoginAndRegiserService {


    @RequestMapping("/login")
    @ResponseBody
    public String login(int userId, String password) {
        Session session = HibernateUtil.getSessionobject();
        Transaction tx = session.beginTransaction();
        System.out.println(userId+"11111111");

        BaseDaoImpl baseDao = new BaseDaoImpl();
        TableUserEntity result = baseDao.get(TableUserEntity.class, userId);
        System.out.println(result);

        tx.commit();
        if (result != null) {
            if (result.getUserPassword().equals(password)) {
                System.out.println(password);
               return "{\"res\":\"登陆成功\"}";
                /*return result.toString();*/
            } else {
                return "{\"res\":\"密码错误\"}";
            }


        } else {
            return "{\"res\":\"用户不存在\"}";
        }


    }

    @RequestMapping("/register")
    public String register(String name, String password, int QQ, String mail, String type) {

        UserService userService = new UserService();
        userService.addUser(name, password, QQ, mail, type);

        return "{\"res\":\"注册成功\"}";
    }

}
