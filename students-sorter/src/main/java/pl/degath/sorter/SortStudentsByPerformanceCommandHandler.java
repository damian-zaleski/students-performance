package pl.degath.sorter;


import jakarta.inject.Singleton;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;
import pl.degath.sorter.port.StudentSorter;

import java.util.List;

@Singleton
public class SortStudentsByPerformanceCommandHandler {

    private final List<StudentSorter> studentSorters;

    public SortStudentsByPerformanceCommandHandler(List<StudentSorter> studentSorters) {
        this.studentSorters = studentSorters;
    }

    public SortStudentsByPerformanceResult sortStudentsByPerformance(SortStudentsByPerformanceCommand command) {
        return studentSorters.stream()
                .filter(studentSorter -> command.algorithmName().equals(studentSorter.algorithmName()))
                .map(studentSorter -> {
                    long startTime = System.nanoTime();
                    var students = studentSorter.sortByPerformance(command.students());
                    long endTime = System.nanoTime();
                    long elapsedTimeInNs = endTime - startTime;

                    return new SortStudentsByPerformanceResult(students, students.size(), elapsedTimeInNs);
                })
                .findFirst()
                .orElseThrow();
    }
}

