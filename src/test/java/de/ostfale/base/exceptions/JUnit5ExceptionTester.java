package de.ostfale.base.exceptions;

import de.ostfale.base.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

/**
 * Example for testing exceptions
 * Created :  02.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class JUnit5ExceptionTester {

    private Calculator calculator = new Calculator();

    @Test
    public void expectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1));
    }

    @Test
    public void expectArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
