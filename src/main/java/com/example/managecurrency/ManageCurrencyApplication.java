package com.example.managecurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ManageCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCurrencyApplication.class, args);
	}

}
