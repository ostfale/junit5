package de.ostfale.base.assertions;

import de.ostfale.base.model.Job;
import de.ostfale.base.model.SUT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * The following listing shows the use of some assertTimeout and assertTimeoutPreemptively methods,
 * which replace the JUnit 4 Timeout Rule.
 * Created :  20.03.2020ass
 *
 * @author : Uwe Sauerbrei
 */
public class AssertTimeoutTest {

    private SUT systemUnderTest = new SUT("Our system under test");

    @Test
    @DisplayName("A job is executed within a timeout")
    void testTimeout() throws InterruptedException {
        systemUnderTest.addJob(new Job("Job 1"));
        assertTimeout(ofMillis(500), () -> systemUnderTest.run(200));
    }

    @Test
    @DisplayName("A job is executed preemptively within a timeout")
    void testTimeoutPreemptively() throws InterruptedException {
        systemUnderTest.addJob(new Job("Job 1"));
        assertTimeoutPreemptively(ofMillis(500), () -> systemUnderTest.run(200));
    }
}
