package com.capp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CoinAppEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinAppEurekaServerApplication.class, args);
	}

}
