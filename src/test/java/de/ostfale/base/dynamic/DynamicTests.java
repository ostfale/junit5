package de.ostfale.base.dynamic;

import org.junit.jupiter.api.*;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * A dynamic test has a different life cycle than a standard test annotated with @Test. The  methods annotated with @BeforeEach and  @AfterEach
 * are executed for the @TestFactory method but not for each dynamic test; other than these methods, there are no life
 * cycle callbacks for individual dynamic tests. The behavior of @BeforeAll and @AfterAll remains the same; they are executed before
 * all tests and at the end of all tests.
 * <p>
 * Created :  27.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class DynamicTests {

    private PositiveNumberPredicate predicate = new PositiveNumberPredicate();

    /*
     * The methods annotated with @BeforeAll and @AfterAll are executed once as expected:
     * at the beginning and at the end of the entire tests list, respectively.
     */
    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }

    /*
     * The methods annotated with @BeforeEach and @AfterEach are executed before
     * and after the execution of the @TestFactory annotated method, respectively
     */
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }

    /*
     * This factory method generates three test methods labeled "negative number", "zero" and "positive number"
     * The effective behavior of each test is given by the Executable provided as the second parameter of the dynamicTest method.
     */
    @TestFactory
    Iterator<DynamicTest> positiveNumberPredicateTestCases() {
        return asList(
                dynamicTest("negative number", () -> assertFalse(predicate.check(-1))),
                dynamicTest("zero", () -> assertFalse(predicate.check(0))),
                dynamicTest("positive number", () -> assertTrue(predicate.check(1)))
        ).iterator();
    }
}
