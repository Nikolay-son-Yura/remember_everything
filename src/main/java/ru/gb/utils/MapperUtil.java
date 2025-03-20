package ru.gb.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.user.dto.UserDto;
import ru.gb.user.model.User;
import ru.gb.user.repository.task.dto.TaskDto;
import ru.gb.user.repository.task.model.Task;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    @Autowired
    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertToUserDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public TaskDto convertToTaskDto(Task task){
        return modelMapper.map(task, TaskDto.class);
    }
    public Task convertToTask(TaskDto taskDto){
        return modelMapper.map(taskDto,Task.class);
    }
}
