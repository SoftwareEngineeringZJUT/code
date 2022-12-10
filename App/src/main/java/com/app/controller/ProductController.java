package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.AdminDao;
import com.app.dao.OrderDao;
import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.Order;
import com.app.domain.Product;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     *  产品编排(增加)
     *  产品查询
     *      用户
     *      管理员
     *  产品修改
     *  产品删除
     *
     *  产品购买
     *  产品卖出
     *
     *
     */

    @Resource
    private ProductDao productDao;
    @Resource
    private AdminDao adminDao;
    @Resource
    private UserDao userDao;
    @Resource
    private OrderDao orderDao;
    final Integer SUPER_ADMIN = 5;

    @PostMapping("/adminGetProducts")
    public String adminGetProducts(Admin _admin){
        String retJSON = "[]";

        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
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

    /**
     * 添加新产品
     * @param _admin
     * @param product
     * @return retJSON
     */
    @PostMapping("/addProduct")
    public String addProduct(Admin _admin , Product product){
        String retJSON = "{}";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());

        //管理员不存在
        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }
        //管理员存在
        else
        {
            product.setPublisher(admin.getAdmin_id());
            product.setOnsale(0);
            product.setSaled(0);
            productDao.insertProduct(product);
            retJSON = addKeyValue(retJSON,"status","APPROVED");
        }

        return retJSON;
    }

    /**
     * 用户获取已上线的产品列表
     * @param _user
     * @return retJSON
     */
    @PostMapping("/userGetProducts")
    public String userGetProducts(User _user){
        String retJSON = "[]";
        User user = userDao.getUserByAccount(_user.getAccount());
        // 用户不存在
        if(user == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "USER_NOT_FOUND");
        }
        else
        {
            List<Product> allOnsale = productDao.getAllOnsale();
            retJSON = JSON.toJSONString(allOnsale);
            retJSON = addKeyValue(retJSON,"status","APPROVED");
        }

        return retJSON;
    }

    /**
     * 修改产品信息（基本信息和原子服务信息）
     * @param _admin
     * @param _product
     * @return retJSON
     */
    @PostMapping("/updateProduct")
    public String updateProduct(Admin _admin,Product _product){
        String retJSON = "{}";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
        //不存在
        if(admin == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
        }
        else
        {
            Product product = productDao.getProductById(_product.getProduct_id());
            //修改基本信息
            productDao.UpdateProductInfo(_product);
            //修改原子服务流程（假如传进来的原子服务流程非空）
            if(_product.getService_process() != null &&
                    !product.getService_process().equals(_product.getService_process()))
            {
                productDao.UpdateProcessById(_product.getProduct_id(),_product.getService_process());
            }
            retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        }

        return retJSON;
    }

    /**
     * 删除产品
     * @param _admin
     * @param _product
     * @return retJSON
     */
    @PostMapping("/deleteProduct")
    public String deleteProduct(Admin _admin,Product _product){
        String retJSON = "{}";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
        //不存在
        if(admin == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
        }
        else
        {
            productDao.DeleteById(_product.getProduct_id());
            retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        }
        return retJSON;
    }

    /**
     * 用户买入产品
     * @param _user
     * @param _product
     * @param purchaseVolume
     * @return retJSON
     */
    @PostMapping("/purchaseProduct")
    public String purchaseProduct(User _user,Product _product,double purchaseVolume)
    {
        String retJSON = "{}";
        User user = userDao.getUserByAccount(_user.getAccount());
        Product product = productDao.getProductById(_product.getProduct_id());
        //用户不存在
        if(user == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "USER_NOT_FOUND");

        }
        //产品不存在或不再售卖
        else if (product == null || product.getOnsale() == 0)
        {
            retJSON = addKeyValue(retJSON , "status" , "PRODUCT_NOT_FOUND");
        }
        //TODO: 可能需要加入判断是否超出每日限额、每人限额啥的，后续待改
        else if(product.getStock() - product.getSaled() < purchaseVolume)
        {
            //判断能否支付
            //产品余量不足
            retJSON = addKeyValue(retJSON , "status" , "Deficiency_of_allowance");
        }
        else if(user.getBalance() < purchaseVolume)
        {
            //用户余额不足（不判断银行卡了，要求用户把银行卡里的钱充值到余额，只判断余额）
            retJSON = addKeyValue(retJSON , "status" , "Lack_of_balance");
        }
        else
        {
            //扣款
            userDao.updateBalanceByUid(user.getUid(),user.getBalance() - purchaseVolume);

            //生成订单
            Order order = new Order(product.getProduct_id(), user.getUid(),purchaseVolume,0,new Date());
            orderDao.InsertOrder(order);
            //产品库存减少
            product.setSaled(product.getSaled() - purchaseVolume);
            productDao.UpdateProductInfo(product);
            retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        }
        return retJSON;
    }

    /**
     * 用户卖出持有的产品
     * @param _user
     * @param _product
     * @param saleVolume
     * @return retJSON
     */
    @PostMapping("saleProduct")
    public String saleProduct(User _user,Product _product,double saleVolume)
    {
        String retJSON = "{}";
        User user = userDao.getUserByAccount(_user.getAccount());
        Product product = productDao.getProductById(_product.getProduct_id());
        //用户不存在
        if(user == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "USER_NOT_FOUND");

        }
        //产品不存在
        else if (product == null)
        {
            retJSON = addKeyValue(retJSON , "status" , "PRODUCT_NOT_FOUND");
        }
        //用户是否持有足够库存
        else if(getHold(user,product.getProduct_id()) < saleVolume)
        {
            retJSON = addKeyValue(retJSON , "status" , "PRODUCT_NOT_ENOUGH");
        }
        else
        {
            //生成订单
            Order order = new Order(product.getProduct_id(), user.getUid(),saleVolume,1,new Date());
            orderDao.InsertOrder(order);
            //增加库存
            product.setSaled(product.getSaled() + saleVolume);
            productDao.UpdateProductInfo(product);
            //加余额
            userDao.updateBalanceByUid(user.getUid(),user.getBalance() + saleVolume);

            retJSON = addKeyValue(retJSON , "status" , "APPROVED");

        }
        return retJSON;
    }


    private double getHold(User user , Integer product_id)
    {
        List<Order> orderList = orderDao.GetByUserId(user.getUid());
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

        return productmap.get(product_id);
    }
}
