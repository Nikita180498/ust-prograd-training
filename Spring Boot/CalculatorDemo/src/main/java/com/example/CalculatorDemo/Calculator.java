package com.example.CalculatorDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Calculator {

    @Value("${num1}")
    public double num1;
    @Value("${num2}")
    public double num2;

    public double addition(){
        System.out.println("Addition of " + num1 + " and " + num2 + "= ");
        return (num1 + num2);
    }
    public double subtraction(){
        System.out.println("Subtraction of " + num1 + " and " + num2 + "= ");
        return (num1 - num2);
    }
    public double multiplication(){
        System.out.println("Multiplication of " + num1 + " and " + num2 + "= ");
        return (num1 * num2);
    }
    public double division(){
        System.out.println("Division of " + num1 + " and " + num2 + "= ");
        return (num1 / num2);
    }
}
