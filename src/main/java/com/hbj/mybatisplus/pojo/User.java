package com.hbj.mybatisplus.pojo;

public class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        User user = new User("1", "wang");
        StringBuilder stringBuilder = new StringBuilder();
        String s = ",";
        System.out.println(stringBuilder.append(s + user.getId()).append(s + user.getName()));

    }
}
