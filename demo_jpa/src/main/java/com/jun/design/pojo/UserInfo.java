package com.jun.design.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018-1-6.
 */
public class UserInfo {
    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long")
    // 使用该注解描述属性信息,当hidden=true时，该属性不会在api中显示
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ApiModelProperty(value = "名字")
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}