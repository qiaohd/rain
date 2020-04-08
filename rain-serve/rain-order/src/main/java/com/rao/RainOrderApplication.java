package com.rao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author raojing
 * @data 2020/4/8 9:34
 */
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(value = "com.rao.dao")
@SpringBootApplication
public class RainOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RainOrderApplication.class, args);
    }

}
