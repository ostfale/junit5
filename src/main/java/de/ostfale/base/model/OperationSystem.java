package de.ostfale.base.model;

/**
 * <description>
 * Created :  23.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class OperationSystem {
    private String name;
    private String architecture;

    public OperationSystem(String name, String architecture) {
        this.name = name;
        this.architecture = architecture;
    }

    public String getName() {
        return name;
    }

    public String getArchitecture() {
        return architecture;
    }
}
