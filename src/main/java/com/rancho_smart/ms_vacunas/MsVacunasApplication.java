package com.rancho_smart.ms_vacunas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsVacunasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVacunasApplication.class, args);
	}

}
