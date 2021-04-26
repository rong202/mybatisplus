package com.hbj.mybatisplus.pojo;

import com.hbj.mybatisplus.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
仅演示使用自定义模板
*/
@ApiModel("女孩类")
@Data
public class Girl implements Serializable {
    private int id;
    private String name;
    @ApiModelProperty("生日")
    private String birthday;
    private String age;
    private String z;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}