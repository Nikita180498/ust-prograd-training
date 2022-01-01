package com.example.CalculatorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CalculatorDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(CalculatorDemoApplication.class, args);

		Calculator calculator = context.getBean(Calculator.class);
		System.out.println(calculator.addition());
		System.out.println(calculator.subtraction());
		System.out.println(calculator.multiplication());
		System.out.println(calculator.division());
	}

}
