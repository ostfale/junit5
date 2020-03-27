package de.ostfale.base.parameterized;

import de.ostfale.base.model.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The @CsvFileSource allows us to use CSV files from the classpath. The parameterized test is executed once for each line of a CSV file.
 * <p>
 * Created :  27.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ParameterizedWithCsvFileSourceTest {
    private WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @CsvFileSource(resources = "/word_counter.csv")
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, wordCounter.countWords(sentence));
    }

}
