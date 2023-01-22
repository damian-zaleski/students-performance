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

    public List<Student> sortStudentsByPerformance(SortStudentsByPerformanceCommand command) {
        return studentSorters.stream()
                .filter(studentSorter -> command.algorithmName().equals(studentSorter.algorithmName()))
                .map(studentSorter -> studentSorter.sortByPerformance(command.students()))
                .findFirst()
                .orElseThrow();
    }
}
