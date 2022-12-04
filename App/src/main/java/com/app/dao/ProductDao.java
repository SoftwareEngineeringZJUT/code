package com.app.dao;

import com.app.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDao {
    //插入一条新记录
    @Insert("insert into product(product_id,name,publisher,expire,annual_rate,start_deposit,increment,personal_limit,daily_limit,stock,risk,settlement_type,onsale,description,service_process,gmt_create,gmt_update)" +
            "values(NULL,#{name},#{publisher},#{expire},#{annual_rate},#{start_deposit},#{increment},#{personal_limit},#{daily_limit},#{stock},#{risk},#{settlement_type},#{onsale},#{description},#{service_process},#{gmt_create},#{gmt_update})")
    void insertProduct(Product product);

    //获取全部product
    @Select("select * from product")
    List<Product> getAll();

    //根据商品id查询商品全部信息
    @Select("select * from product where product_id=#{product_id}")
    Product getProductById(Integer product_id);

    //根据发布者（外键publisher，指向admin_id，是admin表的主键）查询发布者相同的产品
    @Select("select * from product group by publisher")
    List<Product> getPublisherProducts();

    //根据商品名称进行模糊查询，得到商品全部信息
    @Select("select * from product where name like '%#{name}%'")
    List<Product> queryProductLikeName(String name);

    //根据商品id修改商品基础信息，包括商品名称、商品期限、年转化率、起存金额、递增金额、每人限额
    // 、每日限额、产品库存、风险等级、结息方式、是否上线、商品说明
    @Update("update product set name = #{name} , expire = #{expire} , annual_rate = #{annual_rate} ,start_deposit = #{start_deposit} , " +
    "increment =  #{increment} , personal_limit = #{personal_limit} ,daily_limit = #{daily_limit} , stock = #{stock , risk = #{risk} , " +
    "settlement_type = #{settlement_type} , onsale = #{onsale} , description = #{description}")
    void UpdateProductInfo(Product product);

    //根据商品id修改商品原子服务流程
    @Update("update product set service_process=#{service_process} where product_id=#{product_id}")
    void UpdateProcessById(String product_id , String service_process);

    //根据商品id删除一条记录
    @Delete("delete from product where product_id=#{product_id}")
    void DeleteById(String product_id);

}
