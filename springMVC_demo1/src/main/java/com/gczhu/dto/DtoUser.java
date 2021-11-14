package com.gczhu.dto;

public class DtoUser {
    private String userName;
    private String age;

    public DtoUser() {
    }

    public DtoUser(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DtoUser{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
