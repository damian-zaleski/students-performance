package pl.degath.rest;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import pl.degath.sorter.Student;

import java.util.List;
import java.util.Objects;

@JsonClassDescription
public record SortResponse(List<Student> students, int size) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SortResponse) obj;
        return Objects.equals(this.students, that.students) &&
                this.size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, size);
    }

    @Override
    public String toString() {
        return "SortResponse[" +
                "students=" + students + ", " +
                "size=" + size + ']';
    }

}

