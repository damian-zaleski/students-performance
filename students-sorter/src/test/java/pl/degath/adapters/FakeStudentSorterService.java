package pl.degath.adapters;

import pl.degath.sorter.Student;
import pl.degath.sorter.port.StudentSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FakeStudentSorterService implements StudentSorter {
    @Override
    public String algorithmName() {
        return "fake";
    }

    @Override
    public List<Student> sortByPerformance(List<Student> studentsToSort) {
        var students = new ArrayList<>(studentsToSort);
        students.sort(Comparator.comparing(Student::performance));
        return students;
    }
}
