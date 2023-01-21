package pl.degath.sorter.port;

import pl.degath.sorter.Student;

import java.util.List;

public interface StudentSorterApi {

    List<Student> sortByPerformance(List<Student> students);
}
