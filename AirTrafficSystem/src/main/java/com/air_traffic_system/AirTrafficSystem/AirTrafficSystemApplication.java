package com.air_traffic_system.AirTrafficSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.air_traffic_system" })
@EntityScan(basePackages = { "com.air_traffic_system" })
public class AirTrafficSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirTrafficSystemApplication.class, args);
	}
}
