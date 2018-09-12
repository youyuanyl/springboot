package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.gft"})
@MapperScan("com.gft")
public class ApplicationStart extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationStart.class);
	}
	
	public static void main(String[] args) {
		System.out.println("=============开始启动!===============");
		SpringApplication.run(ApplicationStart.class);
		System.out.println("=============启动成功！===============");
	}
	
}
