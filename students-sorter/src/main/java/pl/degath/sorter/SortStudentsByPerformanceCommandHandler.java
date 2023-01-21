package pl.degath.sorter;


import jakarta.inject.Singleton;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;
import pl.degath.sorter.port.StudentSorter;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.List;

@Singleton
public class SortStudentsByPerformanceCommandHandler {

    private final List<StudentSorter> studentSorters;
    private final StudentSourceApi studentSourceApi;

    public SortStudentsByPerformanceCommandHandler(List<StudentSorter> studentSorters, StudentSourceApi studentSourceApi) {
        this.studentSorters = studentSorters;
        this.studentSourceApi = studentSourceApi;
    }

    public List<Student> sortStudentsByPerformance(SortStudentsByPerformanceCommand command) {
        List<Student> students = studentSourceApi.findAll();
        return studentSorters.stream()
                .filter(studentSorter -> command.algorithmName().equals(studentSorter.algorithmName()))
                .map(studentSorter -> studentSorter.sortByPerformance(students))
                .findFirst()
                .orElseThrow();
    }
}
