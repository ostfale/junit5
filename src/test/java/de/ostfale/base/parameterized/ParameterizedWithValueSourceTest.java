package de.ostfale.base.parameterized;

import de.ostfale.base.model.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Parameterized tests allow a test to run multiple times with different arguments. The great benefit is that we can write a single
 * test to be performed using arguments that check various input data.
 * <p>
 * Created :  25.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ParameterizedWithValueSourceTest {

    private WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @ValueSource(strings = {"Check three parameters", "JUnit in Action"})
    void testWordsInSentence(String sentence) {
        assertEquals(3, wordCounter.countWords(sentence));
    }
}

