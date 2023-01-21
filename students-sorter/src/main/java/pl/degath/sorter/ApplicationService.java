package pl.degath.sorter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationService {

    List<Student> sortStudentsByPerformance(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return List.of();
        }
        if (students.size() == 1) {
            return students;
        }

        return students.stream()
                .sorted(Comparator.comparing(Student::performance))
                .collect(Collectors.toList());
    }
}
