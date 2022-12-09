package com.app.dao;

import com.app.domain.Bank;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankDao {
    //插入新记录
    @Insert("insert into bank values(#{bank_card},#{bank_balance},#{gmt_create},#{gmt_create})")
    void insertBank(Bank bank);

    //获取全部
    @Select("select * from bank")
    List<Bank> getAll();

    //根据银行卡号查询银行卡余额
    @Select("select bank_balance from bank where bank_card = #{bank_card}")
    double getBalanceByCard(String bank_card);

    //根据银行卡号修改银行卡余额
    @Update("update bank set bank_balance = #{bank_balance} where bank_card = #{bank_card}")
    void updateBalanceByCard(String bank_card , double bank_balance);

    //删除银行卡记录
    @Delete("delete from bank where bank_card = #{bank_card}")
    void deleteCard(String bank_card);

    @Select("select * from bank where bank_card = #{bank_card}")
    Bank getBankByBankCard(String bank_card);
}
