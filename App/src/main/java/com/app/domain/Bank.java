package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    /**
     *  银行卡号
     */
    @JSONField(ordinal = 1)
    private String bank_card;

    /**
     *  银行卡余额
     */
    @JSONField(ordinal = 2)
    private double bank_balance;
}
