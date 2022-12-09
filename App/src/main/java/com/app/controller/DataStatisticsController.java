package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.app.dao.*;
import com.app.domain.Admin;
import com.app.domain.Order;
import com.app.domain.Product;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/statistics")
public class DataStatisticsController {

    /**
     *  产品收益
     *      用户查看
     *      管理员查看
     *  客户资产分布
     *
     *
     *
     *
     */

    @Resource
    private OrderDao orderDao;
    @Resource
    private UserDao userDao;
    @Resource
    private BankDao bankDao;
    @Resource
    private ProductDao productDao;
    @Resource
    private AdminDao adminDao;

    final Integer SUPER_ADMIN = 5;

    @PostMapping("/userQueryProfits")
    public String userQueryProfits(User user){
        String retJSON = "[]";

        List<Order> orderList = orderDao.GetByUserId(user.getUid());

        if(orderList == null){
            return retJSON;
        }

        System.out.println(orderList);

        Map<Integer , Double> productmap = new HashMap<>();

        for(Order order:orderList){

            Integer id = order.getProduct_id();
            Double num = order.getAmount();
            Integer state = order.getState();
            // state = 0 买进
            if(state == 0 && productmap.get(id) != null){
                    num = productmap.get(id) + num;
                    productmap.remove(id);
            }
            // 1 卖出
            else if(state == 1){
                num = productmap.get(id) - num;
                productmap.remove(id);
            }
            productmap.put(id , num);
        }

        JSONArray jsonArray = new JSONArray();
        for(Integer key:productmap.keySet()){
            Double num = productmap.get(key);
            if(num == 0) continue;

            JSONObject jsonObject = new JSONObject();

            Product product = productDao.getProductById(key);

            String productJSON = JSON.toJSONString(product);
            jsonObject = JSON.parseObject(productJSON);
            jsonObject.put("user_hold", num);
            jsonArray.add(jsonObject);
        }

        retJSON = JSON.toJSONString(jsonArray);

        return retJSON;
    }


    @PostMapping("/adminQueryProfits")
    public String adminQueryProfits(Admin admin){

        String retJSON = "[]";

        admin = adminDao.getAdminByAccount(admin.getAccount());
        List<Product> productList ;

        if(admin == null){
            return retJSON;
        }

        // 超级管理员
        if(admin.getRank() > SUPER_ADMIN){
            productList = productDao.getAll();
        }
        // 普通管理员
        else{
            productList = productDao.getProductByPublisher(admin.getAdmin_id());
        }

        retJSON = JSON.toJSONString(productList);

        return retJSON;

    }

    @PostMapping("/getUserAssetDistribution")
    public String getUserAssetDistribution(){

        String retJSON = "{}";
        Map<Integer , Double> asset = new HashMap<>();

        List<User> userList = userDao.getAll();

        for(User user:userList){
            Integer id = user.getUid();
            Double capital = user.getBalance();
            asset.put(id , capital);
        }

        List<Order> orderList = orderDao.GetAllOrder();

        for(Order order:orderList){
            Integer id = order.getUser_id();
            Double capital = order.getAmount();
            Integer state = order.getState();

            if(state == 0){
                capital = asset.get(id) + capital;
            } else {
                capital = asset.get(id) - capital;
            }
            asset.remove(id);
            asset.put(id , capital);
        }

        Integer level_1 = 0 ,   // 0 - 1 0000
                level_2 = 0 ,   // 1 0000 - 10 0000
                level_3 = 0 ,   // 10 0000 - 100 0000
                level_4 = 0 ,   // 100 0000 - 500 0000
                level_5 = 0 ,   // 500 0000 - 1000 0000
                level_6 = 0 ;   // 1000 0000 +

        Integer threshold_1 = 10000 ,
                threshold_2 = 100000 ,
                threshold_3 = 1000000 ,
                threshold_4 = 5000000 ,
                threshold_5 = 1000000 ;

        for(Integer key:asset.keySet()){
            Double val = asset.get(key);
            if(val < threshold_1)       ++level_1;
            else if(val < threshold_2)  ++level_2;
            else if(val < threshold_3)  ++level_3;
            else if(val < threshold_4)  ++level_4;
            else if(val < threshold_5)  ++level_5;
            else                        ++level_6;
        }

        retJSON = addKeyValue(retJSON , "level_1" , level_1);
        retJSON = addKeyValue(retJSON , "level_2" , level_2);
        retJSON = addKeyValue(retJSON , "level_3" , level_3);
        retJSON = addKeyValue(retJSON , "level_4" , level_4);
        retJSON = addKeyValue(retJSON , "level_5" , level_5);
        retJSON = addKeyValue(retJSON , "level_6" , level_6);

        return retJSON;
    }

}
