package de.ostfale.base.model;

/**
 * Helper class which counts words
 * Created :  25.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class WordCounter {
    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}
