package com.ticketing.dto;

import com.ticketing.utils.Status;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDTO {
    private Long id;
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject, taskDetail;
    Status taskStatus;
    private LocalDate assignedDate;
}
