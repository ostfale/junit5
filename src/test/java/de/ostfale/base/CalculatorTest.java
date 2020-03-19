package de.ostfale.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Calculator} class
 * Created :  18.03.2020
 *
 * @author : Uwe Sauerbrei
 */
@DisplayName("Test class showing basic JUnit functionality")
class CalculatorTest {

    @Test
    @DisplayName("Test add functionality")
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }
}
