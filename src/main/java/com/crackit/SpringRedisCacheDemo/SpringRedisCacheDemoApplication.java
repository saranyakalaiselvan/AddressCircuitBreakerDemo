package com.crackit.SpringRedisCacheDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCacheDemoApplication.class, args);
	}

}
