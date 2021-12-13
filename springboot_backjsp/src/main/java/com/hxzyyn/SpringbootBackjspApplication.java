package com.hxzyyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口类
 * MapperScan() Mybatis 映射扫描的包
 */
@SpringBootApplication
@MapperScan("com.hxzyyn.dao") //告诉它去哪里找接口  必须加
public class SpringbootBackjspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackjspApplication.class, args);
    }

}
