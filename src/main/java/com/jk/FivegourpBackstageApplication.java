package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan(basePackages= {"com.jk.mapper"})
public class FivegourpBackstageApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FivegourpBackstageApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FivegourpBackstageApplication.class, args);
	}
}
