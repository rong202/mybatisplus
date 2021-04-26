package com.hbj.mybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;



    public static void main(String[] args) {
        User user = new User("1", "wang");
        StringBuilder stringBuilder = new StringBuilder();
        String s = ",";
        System.out.println(stringBuilder.append(s + user.getId()).append(s + user.getName()));

    }
}
