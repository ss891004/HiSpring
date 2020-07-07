package org.example.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean gender;
    private Date registerTime;

    public User(){}
    public User(Integer id, String username, String password, Boolean gender, Date registerTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", registTime=" + registerTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registTime) {
        this.registerTime = registTime;
    }
}
