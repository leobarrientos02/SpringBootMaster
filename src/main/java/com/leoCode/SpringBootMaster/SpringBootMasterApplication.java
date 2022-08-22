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
/*
	In order to package and run the application you will need to use the
	mvn clean command to clean the target folder and with the mvn clean install
	command you can generate a new target folder with the new jar files.

	To run the jar file you use the "java -jar <jar File>" command

	To include program arguments with the jar snapshot you can simply
	include the program argument with the command, in this example
	ex: "java -jar <jar File>" --spring.profiles.active=prod

	To run multiple instances we can add the "--server.port=<PORT NUMBER>" command
	with the command to run the jar snapshot.
	ex:"java -jar <jar File>" --spring.profiles.active=dev --server.port=3000
 */
