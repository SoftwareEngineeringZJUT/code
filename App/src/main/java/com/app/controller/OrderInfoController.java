package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.AdminDao;
import com.app.dao.OrderDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.Order;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/order")
public class OrderInfoController {
//         *  订单管理
//     *      增加
//     *      删除
//     *      查询
//     *      更改
//     */

    @Resource
    private OrderDao orderDao;
    @Resource
    private AdminDao adminDao;
    @Resource
    private UserDao userDao;
    @PostMapping("/addOrder")
    public String addOrder(Order order){
        orderDao.InsertOrder(order);

        String retJSON = "{}";
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        return retJSON;
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(Order order){
        String retJSON = "{}";

        order = orderDao.GetById(order.getId());

        if(order == null){
            retJSON = addKeyValue(retJSON , "status" , "ORDER_NOT_FOUND");
            return retJSON;
        }

        orderDao.DeleteById(order.getUser_id());
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        return retJSON;
    }

    /**
     * 查询订单
     *      管理员查询
     * @param _admin
     * @return retJSON
     */
    @PostMapping("/AdminQueryOrder")
    public String AdminQueryOrder(Admin _admin){
        String retJSON = "[]";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());

        // 用户不存在
        if(admin == null){
//            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }
        List<Order> orderList = orderDao.GetAllOrder();
        retJSON = JSON.toJSONString(orderList);
//        retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        return retJSON;
    }
    /**
     * 查询订单
     *      用户查询
     * @param _user
     * @return retJSON
     */
    @PostMapping("/UserQueryOrder")
    public String UserQueryOrder(User _user){
        String retJSON = "[]";
        User user = userDao.getUserByAccount(_user.getAccount());

        // 用户不存在
        if(user == null){
//            retJSON = addKeyValue(retJSON , "status" , "USER_NOT_FOUND");
            return retJSON;
        }
        List<Order> orderList = orderDao.GetByUserId(user.getUid());
        retJSON = JSON.toJSONString(orderList);
//        retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        return retJSON;
    }
    @PostMapping("/updateOrder")
    public String updateOrder(Order order){
        String retJSON = "{}";

        orderDao.update(order);

        retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        return retJSON;

    }
}
