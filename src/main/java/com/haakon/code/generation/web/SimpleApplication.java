package com.haakon.code.generation.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.haakon.code.generation")
@MapperScan("com.haakon.code.generation.mapper")
public class SimpleApplication {
//erer
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}
}
