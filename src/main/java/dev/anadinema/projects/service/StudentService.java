package dev.anadinema.projects.service;

import dev.anadinema.projects.mapper.StudentMapper;
import dev.anadinema.projects.model.StudentRequest;
import dev.anadinema.projects.model.StudentResponse;
import dev.anadinema.projects.persistence.StudentEntity;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.List;

@ApplicationScoped
public class StudentService {

    @WithTransaction
    public Uni<List<StudentEntity>> fetchAllFromDatabase() {
        return StudentEntity.listAll();
    }

    @WithTransaction
    public Uni<StudentEntity> fetchStudent(Long id) {
        return StudentEntity.findById(id);
    }

    @WithTransaction
    public Uni<StudentResponse> createStudent(StudentRequest studentRequest) {
        var response = StudentResponse.builder().operation("CREATE");
        return StudentMapper.toEntity(studentRequest).persist()
                .onItem()
                .ifNotNull()
                .transform(
                        item -> response.success(true).message("Student added successfully!").build()
                );
    }
}
