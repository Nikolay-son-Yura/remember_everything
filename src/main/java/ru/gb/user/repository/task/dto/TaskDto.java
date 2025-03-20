package ru.gb.user.repository.task.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String header;
    private String description;
    private boolean status;


}
