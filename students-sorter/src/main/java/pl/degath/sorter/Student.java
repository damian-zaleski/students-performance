package pl.degath.sorter;

import java.util.Objects;

public final class Student {
    private final String name;
    private final Double performance;

    public Student(String name, Double performance) {
        this.name = name;
        this.performance = performance;
    }

    public String name() {
        return name;
    }

    public Double performance() {
        return performance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Student) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, performance);
    }

    @Override
    public String toString() {
        return "Student[" +
                "name=" + name + ", " +
                "performance=" + performance + ']';
    }

}
