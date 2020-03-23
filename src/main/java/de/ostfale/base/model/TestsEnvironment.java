package de.ostfale.base.model;

/**
 * Simple Pojo specifying test environment
 * Created :  23.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class TestsEnvironment {
    private JavaSpecification javaSpecification;
    private OperationSystem operationSystem;

    public TestsEnvironment(JavaSpecification javaSpecification, OperationSystem operationSystem) {
        this.javaSpecification = javaSpecification;
        this.operationSystem = operationSystem;
    }

    public boolean isWindows() {
        return operationSystem.getName().contains("Windows");
    }

    public boolean isAmd64Architecture() {
        return operationSystem.getArchitecture().equals("amd64");
    }

    public String getJavaVersion() {
        return javaSpecification.getVersion();
    }

}

