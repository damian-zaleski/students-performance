package pl.degath.sorter;


import pl.degath.sorter.port.StudentSorterApi;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.List;

public class ApplicationService {

    private final StudentSorterApi studentSorterApi;
    private final StudentSourceApi studentSourceApi;

    public ApplicationService(StudentSorterApi studentSorterApi, StudentSourceApi studentSourceApi) {
        this.studentSorterApi = studentSorterApi;
        this.studentSourceApi = studentSourceApi;
    }

    List<Student> sortStudentsByPerformance() {
        List<Student> students = studentSourceApi.findAll();
        return studentSorterApi.sortByPerformance(students);
    }
}
