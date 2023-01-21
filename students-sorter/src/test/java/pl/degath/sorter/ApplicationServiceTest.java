package pl.degath.sorter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.degath.adapters.FakeStudentSorterService;
import pl.degath.sorter.port.StudentSorterApi;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ApplicationServiceTest {

    private ApplicationService applicationService;


    @BeforeEach
    void setUp() {
        StudentSorterApi fakeStudentSorterService = new FakeStudentSorterService();
        applicationService = new ApplicationService(fakeStudentSorterService);
    }

    @Test
    public void shouldSortUnorderedStudentsByPerformance() {
        Student charlie = new Student("Charlie", 50.0);
        Student lucy = new Student("Lucy", 80.0);
        Student linus = new Student("Linus", 60.0);
        List<Student> students = new ArrayList<>(List.of(charlie, lucy, linus));

        List<Student> sortedStudents = applicationService.sortStudentsByPerformance(students);

        assertThat(sortedStudents).containsExactly(charlie, linus, lucy);
    }
}