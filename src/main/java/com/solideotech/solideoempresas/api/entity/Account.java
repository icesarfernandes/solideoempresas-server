package com.solideotech.solideoempresas.api.entity;

import com.solideotech.solideoempresas.api.enumeration.AccountStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    private int code;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean isActive;
    private String UID;

    @Enumerated(EnumType.STRING)
    @Column(name = "`$account_status`", nullable = false, length = 8)
    private AccountStatusEnum accountStatus = AccountStatusEnum.PENDING;

    public Account(int code, String name, String email, String address, Boolean isActive, AccountStatusEnum accountStatus, String UID,
                   String phoneNumber) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isActive = isActive;
        this.accountStatus = accountStatus;
        this.UID = UID;
        this.phoneNumber = phoneNumber;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public AccountStatusEnum getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatusEnum accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
