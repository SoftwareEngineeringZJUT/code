package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.*;
import com.app.domain.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.*;

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
    @Resource
    private BlackListDao blackListDao;
    @Resource
    private WhiteListDao whiteListDao;


    private String[] atomServices = {
            "用户信息检验",       // 0
            "黑白名控制",        // 1
            "白名单控制",        // 2
            "地域购买控制",       // 3
            "标签控制",         // 4
            "库存锁定",         // 5
            "库存释放",         // 6
            "库存更新",         // 7
            "证件审查",         // 8
            "重复购买",         // 9
            "日志录入",         // 10
            "利息计算"          // 11
    };

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
        product.setName( URLDecoder.decode(product.getName()));
//        product.setExpire( URLDecoder.decode(String.valueOf(product.getExpire())));
        product.setDescription( URLDecoder.decode(product.getDescription()));
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
//            retJSON = addKeyValue(retJSON , "status" , "USER_NOT_FOUND");
        }
        else
        {
            List<Product> allOnsale = productDao.getAllOnsale();
            retJSON = JSON.toJSONString(allOnsale);
//            retJSON = addKeyValue(retJSON,"status","APPROVED");
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
//            System.out.println(_product);
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
            return retJSON;
        }
        //产品不存在或不再售卖
        if (product == null || product.getOnsale() == 0)
        {
            retJSON = addKeyValue(retJSON , "status" , "PRODUCT_NOT_FOUND");
            return retJSON;
        }

        // 执行原子流程
        String atomStatus = atomServicesRun(user , product);
        if(!atomStatus.equals("")){
            retJSON = addKeyValue(retJSON , "status" , atomStatus);
            return retJSON;
        }


        //TODO: 可能需要加入判断是否超出每日限额、每人限额啥的，后续待改
        if(product.getStock() - product.getSaled() < purchaseVolume)
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


    // 验证基础信息是否符合要求 ，因为有些操作会对数据库进行修改所以要提前判断 返回为空就代表正确
    private String atomServicesValid(User user , Product product){
        String[] services = product.getService_process().split(";");
        String ret = "";
        for(String id:services){
            // 用户信息检验
            if(id.equals("0")){
                if(!userInfoCheck(user))
                    ret = ret.concat("用户信息错误;");
            }
            // 黑名单控制
            if(id.equals("1")){
                if(!blackListCheck(user))
                    ret = ret.concat("在黑名单中;");
            }
            // 白名单控制
            if(id.equals("2")){
                if(!WhiteListCheck(user))
                    ret = ret.concat("不在白名单中;");
            }
            // 地域购买控制
            if(id.equals("3")){
                if(!userLabelCheck(user , product , 2))
                    ret = ret.concat("地域购买限制;");
            }
            // 证件审查
            if(id.equals("8")){
                if(!certificateCheck(user))
                    ret = ret.concat("证件审查问题;");
            }
            // 重复购买
            if(id.equals("9")){
                if(!rebuyCheck(user , product))
                    ret = ret.concat("无法重复购买;");
            }
        }
        return ret;
    }

    // 执行原子服务流程
    private String atomServicesRun(User user , Product product){

        String ret = atomServicesValid(user , product);
        if(!ret.equals("")) return ret;

        String[] services = product.getService_process().split(";");
        HashSet<String> servicesset = new HashSet<>();
        for(String se:services) servicesset.add(se);

        // 库存锁定
        if(servicesset.contains("5")){
            stockLock(product);
        }
        // 库存释放
        if(servicesset.contains("6")){
            stockRelease(product);
        }
        // 库存更新
        if(servicesset.contains("7")){
            stockUpdate(product);
        }
        // 日志录入
        if(servicesset.contains("10")){
            logGenerate();
        }
        // 利息计算
        if(servicesset.contains("11")){
            interestCal(product , 100.0 , 12);
        }

        return ret;
    }


    // 用户信息检验
    private Boolean userInfoCheck(User user){
        return true;
    }

    // 黑白名控制
    private Boolean blackListCheck(User user){
        BlackList blackList = blackListDao.FindUid(user.getUid());
        if(blackList == null) return true;
        return false;
    }

    // 白名单控制
    private Boolean WhiteListCheck(User user){
        WhiteList whiteList = whiteListDao.FindUid(user.getUid());
        if(whiteList == null) return false;
        return true;
    }

    // 地域购买控制
    private Boolean userLocCheck(User user , Product product){

        //获取产品的地区
        String loc;
        loc = product.getLocation();
        if(user.getAddress().equals(loc)) return true;
        return false;
    }

    /**
     * 标签控制
     * @param user
     * @param product
     * @param option 1 为完全符合 2为部分符合
     * @return
     */
    private Boolean userLabelCheck(User user , Product product , Integer option){

        Integer count = 0;

        String[] userlabelist = user.getLabel().split(";");
        String[] needlabelist = product.getService_process().split(";");
        HashSet<String> labels = new HashSet<>();
        for(String la:needlabelist) labels.add(la);

        Integer labelnum = needlabelist.length;

        for(String la:userlabelist) {
            if(labels.contains(la)) ++count;
        }

        // 完全符合
        if(option == 1) {
            return (count == labelnum);
        }
        // 部分符合
        else{
            return (count > 0);
        }
    }

    // 库存锁定
    private Boolean stockLock(Product product){
        product.setOnsale(0);
        productDao.UpdateProductInfo(product);
        return true;
    }

    // 库存释放
    private Boolean stockRelease(Product product){
        product.setOnsale(1);
        productDao.UpdateProductInfo(product);
        return true;
    }

    // 库存更新
    private Boolean stockUpdate(Product product){
        productDao.UpdateProductInfo(product);
        return true;
    }

    // 证件审查
    private Boolean certificateCheck(User user){
        return true;
    }

    //重复购买
    private Boolean rebuyCheck(User user , Product product){
        List<Order> orderList;
        orderList = orderDao.GetByUserId(user.getUid());
        for(Order order:orderList){
            if(order.getProduct_id().equals(product.getProduct_id()) )
                return false;
        }
        return true;
    }

    // 日志录入
    private Boolean logGenerate(){

        return true;
    }

    // 利息计算
    private Boolean interestCal(Product product , Double amount , Integer months){

        Double interest = product.getIncrement() * amount * months / 12;

        return true;
    }

}
