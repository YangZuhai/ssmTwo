package com.hxzyyn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author lulei
 * @date 2021年12月11日 09:41:52
 * @Data 代表是一个实体类, 自动生成getter/setter
 * @NoArgsConstructor 无参构造方法
 * @AllArgsConstructor 带所有属性的带参构造方法
 * @ToString 生成重写Object的toString方法
 * @Accessors(chain=true) 生成链式调用 String str="ss"; str.replace("123").("456")
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {

    private int id;
    private String username;
    private String password;
}
