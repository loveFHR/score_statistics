package com.fhr.cuit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FHR
 * @create 2025/03/08 11:01
 */

@SpringBootApplication
@MapperScan("com.fhr.cuit.mapper")
public class PerformanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PerformanceApplication.class);
    }
}