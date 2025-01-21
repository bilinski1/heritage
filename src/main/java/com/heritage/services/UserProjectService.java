package com.heritage.services;

import com.heritage.dto.UserProjectDto;

import java.util.List;

public interface UserProjectService {

    UserProjectDto addUserProject(UserProjectDto userProjectDto);
    UserProjectDto getUserProject(Long id);
    List<UserProjectDto> getAllUserProjects();

}
