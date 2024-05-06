package dev.anadinema.projects.mapper;

import dev.anadinema.projects.model.StudentRequest;
import dev.anadinema.projects.persistence.StudentEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentMapper {

    public static StudentEntity toEntity(StudentRequest studentRequest) {
        return StudentEntity.builder()
                .studentName(
                        String.join(" ",
                                Optional.ofNullable(studentRequest.getFirstName()).orElse("NA"),
                                Optional.ofNullable(studentRequest.getLastName()).orElse("NA"))
                )
                .studentEmailAddress(studentRequest.getEmail())
                .status(studentRequest.getStatus())
                .courses(studentRequest.getCourses())
                .build();
    }

}
