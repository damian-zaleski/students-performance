package pl.degath;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import pl.degath.adapters.FakeStudentSourceService;
import pl.degath.sorter.SortStudentsByPerformanceCommandHandler;
import pl.degath.sorter.Student;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;
import pl.degath.sorter.port.StudentSourceApi;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//todo replace with parametrized test
@MicronautTest
public class SortStudentsByPerformanceCommandHandlerIntegrationTest {
    @Inject
    SortStudentsByPerformanceCommandHandler sortStudentsByPerformanceCommandHandler;

    @Inject
    StudentSourceApi studentSourceApi;

    @MockBean(StudentSourceApi.class)
    public StudentSourceApi studentSourceApi() {
        return new FakeStudentSourceService();
    }

    @Test
    void testBubble() {
        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand("bubble", studentSourceApi.findAll());
        List<Student> result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result).hasSize(3);
    }

    @Test
    void testHeap() {
        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand("heap", studentSourceApi.findAll());
        List<Student> result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result).hasSize(3);
    }

    @Test
    void testMerge() {
        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand("merge", studentSourceApi.findAll());
        List<Student> result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result).hasSize(3);
    }
}
