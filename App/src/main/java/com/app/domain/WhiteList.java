package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiteList {
    /**
     *  白名单用户名
     */
    @JSONField(ordinal = 1)
    private Integer uid;
}
