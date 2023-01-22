package pl.degath.sorter.port;

import pl.degath.sorter.Student;

import java.util.List;

public interface StudentSourceApi {

    List<Student> findAll();
}
