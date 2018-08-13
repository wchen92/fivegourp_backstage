package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan(basePackages= {"com.jk.mapper"})
public class FivegourpBackstageApplication {


	/**
	 * 文件上传配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("1024MB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("1024MB");
		return factory.createMultipartConfig();
	}



	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FivegourpBackstageApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FivegourpBackstageApplication.class, args);
	}
}
