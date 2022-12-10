package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.AdminDao;
import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.Product;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
     *
     *
     */

    @Resource
    private ProductDao productDao;
    @Resource
    private AdminDao adminDao;
    @Resource
    private UserDao userDao;
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
        //产品不存在
        else if (product == null || product.getOnsale() == 0)
        {
            retJSON = addKeyValue(retJSON , "status" , "PRODUCT_NOT_FOUND");
        }
        else
        {
            //判断能否支付
                //产品有余量

                //用户有余额（不判断银行卡了，要求用户把银行卡里的钱充值到余额，只判断余额）
            //扣款

            //生成订单

            //产品库存减少

        }
    }

}
