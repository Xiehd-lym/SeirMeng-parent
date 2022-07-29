package com.haidong.SeirMeng.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.haidong.SeirMeng"})
//·@EnableSwagger2
// @MapperScan(basePackages = {"com.haidong.SeirMeng.service.edu.mapper"})
public class SeirMengEducationApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeirMengEducationApplication.class,args);
    }
}
