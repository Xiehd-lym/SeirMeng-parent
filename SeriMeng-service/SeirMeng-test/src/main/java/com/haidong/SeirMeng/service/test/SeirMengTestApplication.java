package com.haidong.SeirMeng.service.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author xiehd
 * @Date 2022 07 29
 **/
@EnableSwagger2
@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.haidong.SeirMeng"})
public class SeirMengTestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SeirMengTestApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        log.info("\n-----------------------------------------------\n\t"+
                "Application is runing!\n\t"
                +"Swagger-DOC: \t\thttp://localhost:"
                + port + contextPath +
                "/swagger-ui.html\n");  //doc.html
    }
}
