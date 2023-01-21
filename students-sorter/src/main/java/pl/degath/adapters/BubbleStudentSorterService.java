package pl.degath.adapters;

import pl.degath.sorter.Student;
import pl.degath.sorter.port.StudentSorterApi;

import java.util.List;

/**
 * generated via chat openai
 */
public class BubbleStudentSorterService implements StudentSorterApi {
    @Override
    public List<Student> sortByPerformance(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return List.of();
        }
        if (students.size() == 1) {
            return students;
        }

        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).performance() > students.get(j + 1).performance()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        return students;
    }
}
