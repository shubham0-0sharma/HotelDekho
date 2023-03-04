package com.hoteldekho.hotelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelserviceApplication.class, args);
	}

}
