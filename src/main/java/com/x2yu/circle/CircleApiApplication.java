package com.x2yu.circle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.x2yu.circle.mapper")
public class CircleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleApiApplication.class, args);
    }

}
