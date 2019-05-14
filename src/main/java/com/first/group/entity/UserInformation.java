package com.first.group.entity;

import java.util.Date;
import java.util.List;

public class UserInformation {
    private String userid;//账号

    private String username;//用户名

    private String gender;//性别

    private String birthday;//生日

    private String address;//地址

    private String tel;//联系电话

    private String email;//邮箱

    private String photo;//照片

    private Date hiredate;//入职日期

    private String password;//密码

    private String position;//职位

    private String workyear;//入职日期
    private UserRoles roleAuthorities;//用户权限
    private List<UserWages> userWages;//用户工资


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkyear() {
        return workyear;
    }

    public void setWorkyear(String workyear) {
        this.workyear = workyear;
    }

    public List<UserWages> getUserWages() {
        return userWages;
    }

    public void setUserWages(List<UserWages> userWages) {
        this.userWages = userWages;
    }


    public UserRoles getRoleAuthorities() {
        return roleAuthorities;
    }

    public void setRoleAuthorities(UserRoles roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}