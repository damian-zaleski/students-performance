package pl.degath.adapters;

import pl.degath.sorter.Student;
import pl.degath.sorter.port.StudentSorterApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FakeStudentSorterService implements StudentSorterApi {
    @Override
    public List<Student> sortByPerformance(List<Student> studentsToSort) {
        var students = new ArrayList<>(studentsToSort);
        students.sort(Comparator.comparing(Student::performance));
        return students;
    }
}
