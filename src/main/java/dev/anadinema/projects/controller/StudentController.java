package dev.anadinema.projects.controller;

import dev.anadinema.projects.model.StudentRequest;
import dev.anadinema.projects.model.StudentResponse;
import dev.anadinema.projects.persistence.StudentEntity;
import dev.anadinema.projects.service.StudentService;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.math.BigInteger;
import java.util.List;

@Path("/student")
public class StudentController {

    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Path("/all")
    public Uni<List<StudentEntity>> getAllStudents() {
        return studentService.fetchAllFromDatabase();
    }

    @GET
    @Path("/{id}")
    public Uni<StudentEntity> getStudentById(@PathParam("id") @Nonnull Long id) {
        return studentService.fetchStudent(id);
    }

    @POST
    public Uni<StudentResponse> addNewStudent(@Nonnull StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

}
