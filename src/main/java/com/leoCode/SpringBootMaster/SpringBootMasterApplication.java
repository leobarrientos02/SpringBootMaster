package com.leoCode.SpringBootMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.leoCode.SpringBootMaster.jsonplaceholder")
public class SpringBootMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMasterApplication.class, args);
	}

}
