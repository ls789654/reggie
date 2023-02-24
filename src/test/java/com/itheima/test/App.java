package com.itheima.test;

import com.itheima.reggie.ReggieApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author LuSheng
 * @title: App
 * @projectName reggie_day06
 * @description: TODO
 * @date 2023/2/2416:12
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        log.info("项目启动成功...");
    }

}
