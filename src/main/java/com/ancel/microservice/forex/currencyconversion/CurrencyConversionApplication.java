
/**
 * A microservice that communicates to another microservice which is load balanced using ribbon and attached to eureka service discovery
 * @author ancel litto
 */
package com.ancel.microservice.forex.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.ancel.microservice.forex.currencyconversion")
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}

}
