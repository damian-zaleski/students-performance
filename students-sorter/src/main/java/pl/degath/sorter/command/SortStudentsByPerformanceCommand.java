package pl.degath.sorter.command;

import pl.degath.sorter.Student;

import java.util.List;

public record SortStudentsByPerformanceCommand(String algorithmName, List<Student> students) {
}
