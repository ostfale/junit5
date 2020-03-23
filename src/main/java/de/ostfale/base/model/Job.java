package de.ostfale.base.model;

import java.util.Objects;

/**
 * Pojo for test demonstration purpose
 * Created :  19.03.2020
 *
 * @author : Uwe Sauerbrei
 */
public class Job {
    private String name;

    public Job() {
    }

    public Job(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Job{" +
                "getName='" + name + '\'' +
                '}';
    }
}

