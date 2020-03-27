package de.ostfale.base.parameterized;

import de.ostfale.base.model.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * We can use @CsvSource to express argument lists as comma-separated values (CSV), such as  String literals.
 * <p>
 * Created :  27.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ParameterizedWithCsvSourceTest {

    private WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @CsvSource({"2, Unit testing", "3, JUnit in Action", "4, Write solid Java code"})
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, wordCounter.countWords(sentence));
    }
}
