
        package com.raysapp.quantom.Model;


public class User {

    private Integer id;
    private String type;
    private String name;
    private Object email;
    private Object avatar;
    private String avatarOriginal;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public String getAvatarOriginal() {
        return avatarOriginal;
    }

    public void setAvatarOriginal(String avatarOriginal) {
        this.avatarOriginal = avatarOriginal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}