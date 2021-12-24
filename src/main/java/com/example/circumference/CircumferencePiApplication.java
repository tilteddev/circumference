package com.example.circumference;

import com.example.circumference.services.PiCalculationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CircumferencePiApplication {

	@Value("${nthdigits}")
	private int nthDigits;

	public static void main(String[] args) {
		SpringApplication.run(CircumferencePiApplication.class, args);
	}

	@Bean
	public CommandLineRunner preCalculatePi( PiCalculationService piCalculationService) {
		return (args) -> {
			piCalculationService.calculatePINthDigits( nthDigits );
		};
	}
}
