package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.OrderDao;
import com.app.domain.Order;
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

        order = orderDao.GetById(order.getUser_id());

        if(order == null){
            retJSON = addKeyValue(retJSON , "status" , "ORDER_NOT_FOUND");
            return retJSON;
        }

        orderDao.DeleteById(order.getUser_id());
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        return retJSON;
    }

    @PostMapping("/queryOrder")
    public String queryOrder(){
        String retJSON;

        List<Order> orderList = orderDao.GetAllOrder();

        retJSON = JSON.toJSONString(orderList);

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
