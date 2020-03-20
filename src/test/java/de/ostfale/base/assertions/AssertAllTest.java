package de.ostfale.base.assertions;

import de.ostfale.base.model.SUT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Some examples for assertions
 * Created :  20.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class AssertAllTest {

    @Test
    @DisplayName("SUT should default to not being under current verification")
    void testSystemNotVerified() {
        SUT systemUnderTest = new SUT("Our system under test");

        assertAll("By default, SUT is not under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified()));

    }

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification() {
        SUT systemUnderTest = new SUT("Our system under test");
        systemUnderTest.verify();
        assertAll("SUT under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified())
        );
    }

    /*
     *  The next listing shows the use of some assertion methods with messages. Thanks to Supplier<String>, the instructions
     *  required to create a complex message aren’t provided in the case of success. We can use lambda or method references to verify our SUT; they improve performance.
     */
    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification1() {
        SUT systemUnderTest = new SUT("Our system under test");
        systemUnderTest.verify();
        assertTrue(systemUnderTest.isVerified(), () -> "System should be under verification");
    }

    @Test
    @DisplayName("SUT should not be under current verification")
    void testSystemNotUnderVerification() {
        SUT systemUnderTest = new SUT("Our system under test");
        assertFalse(systemUnderTest.isVerified(), () -> "System should not be under verification.");
    }

    @Test
    @DisplayName("SUT should have no current job")
    void testNoJob() {
        SUT systemUnderTest = new SUT("Our system under test");
        assertNull(systemUnderTest.getCurrentJob(), () -> "There should be no current job");
    }
}
