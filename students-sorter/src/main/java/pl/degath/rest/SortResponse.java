package pl.degath.rest;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import pl.degath.sorter.SortStudentsByPerformanceResult;
import pl.degath.sorter.Student;

import java.util.List;

@JsonClassDescription
public record SortResponse(List<Student> students, int studentsCount, long elapsedTimeInMs) {
    public static SortResponse from(SortStudentsByPerformanceResult result) {
        return new SortResponse(result.students(), result.studentsCount(), result.elapsedTime());
    }
}

