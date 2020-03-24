package de.ostfale.base.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

/**
 * Parameters of type TestReporter can be injected into methods of test classes annotated with @BeforeEach, @AfterEach, and @Test.
 * TestReporter can also be used to provide additional information about the test that is run.
 * Created :  24.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class TestReporterTest {

    @Test
    void testReportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("Single value");
    }

    @Test
    void testReportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("Key", "Value");
    }

    @Test
    void testReportMultipleKeyValuePairs(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("user", "John");
        values.put("password", "secret");
        testReporter.publishEntry(values);
    }
}
