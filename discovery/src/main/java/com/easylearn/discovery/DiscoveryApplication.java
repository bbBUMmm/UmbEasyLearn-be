package com.easylearn.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
