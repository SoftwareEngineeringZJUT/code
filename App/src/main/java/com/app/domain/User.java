package com.app.domain;


public class User {
    /**
     * uid 用户标识符
     */
    private Integer uid;
    private String account;
    private String password;
    private String real_name;
    private String id_card;//身份证号
    private String address;
    private String bank_card;//银行卡号
    private String phone;
    private String user_status;
    private Integer balance;//余额
    private String label;//用户标签

    private String gmt_create;

    private String gmt_update;

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_update() {
        return gmt_update;
    }

    public void setGmt_update(String gmt_update) {
        this.gmt_update = gmt_update;
    }

    @Override
    public String toString() {
        return "user{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", real_name='" + real_name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", address='" + address + '\'' +
                ", bank_card='" + bank_card + '\'' +
                ", phone='" + phone + '\'' +
                ", user_status='" + user_status + '\'' +
                ", balance=" + balance +
                ", label='" + label + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
