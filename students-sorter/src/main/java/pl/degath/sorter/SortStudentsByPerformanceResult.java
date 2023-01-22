package pl.degath.sorter;

import java.util.List;

public record SortStudentsByPerformanceResult(List<Student> students, int studentsCount, long elapsedTime) {
}