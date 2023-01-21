package pl.degath.sorter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.degath.adapters.FakeStudentSorterService;
import pl.degath.adapters.FakeStudentSourceService;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;
import pl.degath.sorter.port.StudentSorter;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SortStudentsByPerformanceCommandHandlerTest {

    private SortStudentsByPerformanceCommandHandler sortStudentsByPerformanceCommandHandler;

    @BeforeEach
    void setUp() {
        StudentSorter fakeStudentSorterService = new FakeStudentSorterService();
        StudentSourceApi fakeStudentSourceService = new FakeStudentSourceService();
        sortStudentsByPerformanceCommandHandler = new SortStudentsByPerformanceCommandHandler(List.of(fakeStudentSorterService), fakeStudentSourceService);
    }

    @Test
    public void shouldSortUnorderedStudentsByPerformance() {
        List<Student> sortedStudents = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(new SortStudentsByPerformanceCommand(""));

        assertThat(sortedStudents).isSortedAccordingTo(Comparator.comparing(Student::performance));
    }
}