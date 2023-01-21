package pl.degath.sorter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.degath.adapters.FakeStudentSorterService;
import pl.degath.adapters.FakeStudentSourceService;
import pl.degath.sorter.port.StudentSorterApi;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ApplicationServiceTest {

    private ApplicationService applicationService;

    @BeforeEach
    void setUp() {
        StudentSorterApi fakeStudentSorterService = new FakeStudentSorterService();
        StudentSourceApi fakeStudentSourceService = new FakeStudentSourceService();
        applicationService = new ApplicationService(fakeStudentSorterService, fakeStudentSourceService);
    }

    @Test
    public void shouldSortUnorderedStudentsByPerformance() {
        List<Student> sortedStudents = applicationService.sortStudentsByPerformance();

        assertThat(sortedStudents).isSortedAccordingTo(Comparator.comparing(Student::performance));
    }
}