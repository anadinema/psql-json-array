package dev.anadinema.projects.persistence;

import dev.anadinema.projects.model.Course;
import dev.anadinema.projects.model.StudentStatus;
import dev.anadinema.projects.persistence.converter.JsonConverter;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends PanacheEntity {

    @Column(name = "name")
    String studentName;

    @Column(name = "email_address")
    String studentEmailAddress;

    @Enumerated
    @Column(name = "status")
    StudentStatus status;

    @Column(name = "courses_opted")
    @Convert(converter = JsonConverter.class)
    @JdbcTypeCode(SqlTypes.JSON)
    List<Course> courses;

}
