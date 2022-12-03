package com.app.dao;

import com.app.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    //插入一条新记录
    @Insert("insert into product(product_id,name,publisher,expire,annual_rate,start_deposit,increment,personal_limit,daily_limit,stock,risk,settlement_type,onsale,description,service_process,gmt_create,gmt_update) values(NULL,#{name},#{publisher},#{expire},#{annual_rate},#{start_deposit},#{increment},#{personal_limit},#{daily_limit},#{stock},#{risk},#{settlement_type},#{onsale},#{description},#{service_process},#{gmt_create},#{gmt_update})")
    void insertProduct(Product product);
}
