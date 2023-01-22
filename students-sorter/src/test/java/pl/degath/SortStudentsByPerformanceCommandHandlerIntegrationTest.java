package pl.degath;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import pl.degath.adapters.FakeStudentSourceService;
import pl.degath.sorter.SortStudentsByPerformanceCommandHandler;
import pl.degath.sorter.SortStudentsByPerformanceResult;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;
import pl.degath.sorter.port.StudentSourceApi;

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

        SortStudentsByPerformanceResult result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result.students()).hasSize(3);
        assertThat(result.studentsCount()).isEqualTo(3);
        assertThat(result.elapsedTime()).isNotNull();
    }

    @Test
    void testHeap() {
        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand("heap", studentSourceApi.findAll());

        SortStudentsByPerformanceResult result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result.students()).hasSize(3);
        assertThat(result.studentsCount()).isEqualTo(3);
        assertThat(result.elapsedTime()).isNotNull();
    }

    @Test
    void testMerge() {
        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand("merge", studentSourceApi.findAll());
        SortStudentsByPerformanceResult result = sortStudentsByPerformanceCommandHandler.sortStudentsByPerformance(command);

        assertThat(result.students()).hasSize(3);
        assertThat(result.studentsCount()).isEqualTo(3);
        assertThat(result.elapsedTime()).isNotNull();
    }
}
