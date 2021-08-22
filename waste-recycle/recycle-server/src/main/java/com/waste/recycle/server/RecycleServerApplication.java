package com.waste.recycle.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.waste.recycle.server.mapper")
public class RecycleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecycleServerApplication.class, args);
    }

}
