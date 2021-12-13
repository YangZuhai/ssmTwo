package com.hxzyyn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lulei
 * @date 2021年12月11日 16:39:18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)

//参数名称与数据库字段名一一对应
public class Emp {
    private int id;
    private String name;
    private int age;
    private Date bir;
}
