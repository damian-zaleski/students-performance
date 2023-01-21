package pl.degath.sorter;


import pl.degath.sorter.port.StudentSorterApi;

import java.util.List;

public class ApplicationService {

    private final StudentSorterApi studentSorterApi;

    public ApplicationService(StudentSorterApi studentSorterApi) {
        this.studentSorterApi = studentSorterApi;
    }

    List<Student> sortStudentsByPerformance(List<Student> students) {

        return studentSorterApi.sortByPerformance(students);
    }
}
