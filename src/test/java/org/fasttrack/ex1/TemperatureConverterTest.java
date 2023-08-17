package org.fasttrack.ex1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureConverterTest {
    @Test
    public void testFahrenheitToCelsius() {
        double fahrenheit = 212;
        double expectedCelsius = 100;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        double celsius = 37.7778;
        double expectedFahrenheit = 100;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001);
    }

}
