package dev.anadinema.projects.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Boolean success;
    private String operation;
    private String message;

}
