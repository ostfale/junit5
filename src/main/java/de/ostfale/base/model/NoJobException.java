package de.ostfale.base.model;

/**
 * Exception for testing purpose
 * Created :  19.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class NoJobException extends RuntimeException {
    NoJobException(String message) {
        super(message);
    }
}
