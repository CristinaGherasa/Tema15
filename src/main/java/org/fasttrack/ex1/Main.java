package org.fasttrack.ex1;

import static org.fasttrack.ex1.TemperatureConverter.fahrenheitToCelsius;

public class Main {
    public static void main(String[] args) {
        System.out.println(fahrenheitToCelsius(100));
        System.out.println(fahrenheitToCelsius(0));
        System.out.println(fahrenheitToCelsius(50));
    }
}