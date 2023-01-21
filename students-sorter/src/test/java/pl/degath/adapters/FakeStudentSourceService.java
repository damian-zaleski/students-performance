package pl.degath.adapters;

import pl.degath.sorter.Student;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.List;

public class FakeStudentSourceService implements StudentSourceApi {

    @Override
    public List<Student> findAll() {
        Student charlie = new Student("Charlie", 50.0);
        Student lucy = new Student("Lucy", 80.0);
        Student linus = new Student("Linus", 60.0);
        return List.of(charlie, lucy, linus);
    }
}
