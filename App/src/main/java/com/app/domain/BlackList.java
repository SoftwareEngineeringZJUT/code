package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {

    /**
     * 黑名单用户名
     */
    @JSONField(ordinal = 1)
    private Integer uid;
}
