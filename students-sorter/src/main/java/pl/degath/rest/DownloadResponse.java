package pl.degath.rest;

import pl.degath.sorter.Student;

import java.util.List;
import java.util.stream.Collectors;

public record DownloadResponse(String response) {
    public static String from(List<Student> sortedStudents) {
        return sortedStudents.stream()
                .map(student -> student.name() + "," + student.performance())
                .collect(Collectors.joining("\n"));
    }
}