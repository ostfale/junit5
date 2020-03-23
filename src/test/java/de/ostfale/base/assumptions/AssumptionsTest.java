package de.ostfale.base.assumptions;

import de.ostfale.base.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * Suppose we have a test that needs to run only in the Windows operating system and in the
 * Java 8 version. These preconditions are turned into JUnit 5 assumptions. A test is executed
 * only if the assumptions are true.
 * <p>
 * Created :  23.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class AssumptionsTest {

    private static String EXPECTED_JAVA_VERSION = "11";

    private TestsEnvironment environment = new TestsEnvironment(
            new JavaSpecification(
                    System.getProperty("java.vm.specification.version")),
            new OperationSystem(
                    System.getProperty("os.name"),
                    System.getProperty("os.arch"))
    );

    private SUT systemUnderTest = new SUT();

    @BeforeEach
    void setUp() {
        assumeTrue(environment.isWindows());
    }

    @Test
    void testNoJobToRun() {
        assumingThat(
                () -> environment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
                () -> assertFalse(systemUnderTest.hasJobToRun()));
    }

    @Test
    void testJobToRun() {
        assumeTrue(environment.isAmd64Architecture());
        systemUnderTest.run(new Job());
        assertTrue(systemUnderTest.hasJobToRun());
    }
}

