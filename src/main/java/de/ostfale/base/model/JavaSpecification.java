package de.ostfale.base.model;

/**
 * Simple pojo wrapping Java version
 * Created :  23.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class JavaSpecification {
    private String version;

    public JavaSpecification(String version) {
        this.version = version;
    }

    String getVersion() {
        return version;
    }
}
