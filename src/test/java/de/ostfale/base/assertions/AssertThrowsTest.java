package de.ostfale.base.assertions;

import de.ostfale.base.model.NoJobException;
import de.ostfale.base.model.SUT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * In some situations, you expect a test to be executed and to throw an exception, so you may force the
 * rest to run under inappropriate conditions or to receive inappropriate input.
 * Created :  20.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class AssertThrowsTest {

    private SUT systemUnderTest = new SUT("Our system under test");

    @Test
    @DisplayName("An exception is expected")
    void testExpectedException() {
        assertThrows(NoJobException.class, systemUnderTest::run);
    }

    @Test
    @DisplayName("An exception is caught")
    void testCatchException() {
        Throwable throwable = assertThrows(NoJobException.class, () -> systemUnderTest.run(1000));
        assertEquals("No jobs on the execution list!", throwable.getMessage());
    }
}
