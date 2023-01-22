package pl.degath.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Part;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.multipart.CompletedFileUpload;
import pl.degath.adapters.StudentSourceFromFileBytesService;
import pl.degath.sorter.SortStudentsByPerformanceCommandHandler;
import pl.degath.sorter.SortStudentsByPerformanceResult;
import pl.degath.sorter.Student;
import pl.degath.sorter.command.SortStudentsByPerformanceCommand;

import java.io.IOException;
import java.util.List;

@Controller("/v1/students")
public class StudentPerformanceController {
    private final SortStudentsByPerformanceCommandHandler commandHandler;


    public StudentPerformanceController(SortStudentsByPerformanceCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Post("/sortByPerformance")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<SortResponse> sort(@Part("file") CompletedFileUpload file, @Part("algorithm") String algorithm) throws IOException {
        List<Student> students = new StudentSourceFromFileBytesService(file.getInputStream()).findAll();

        SortStudentsByPerformanceCommand command = new SortStudentsByPerformanceCommand(algorithm, students);
        SortStudentsByPerformanceResult result = commandHandler.sortStudentsByPerformance(command);

        return HttpResponse.ok(SortResponse.from(result));
    }
}