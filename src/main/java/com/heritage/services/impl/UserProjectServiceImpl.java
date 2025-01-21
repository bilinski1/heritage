package com.heritage.services.impl;

import com.heritage.dto.UserProjectDto;
import com.heritage.entity.UserProject;
import com.heritage.repository.UserProjectRepository;
import com.heritage.services.UserProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserProjectServiceImpl implements UserProjectService {

    private final UserProject userProject;
    private UserProjectRepository userProjectRepository;
    private ModelMapper modelMapper;

    @Override
    public UserProjectDto addUserProject(UserProjectDto userProjectDto) {
        UserProject userProject = modelMapper.map(userProjectDto, UserProject.class);
        UserProject savedUserProject = userProjectRepository.save(userProject);
        return modelMapper.map(savedUserProject, UserProjectDto.class);
    }

    @Override
    public UserProjectDto getUserProject(Long userProjectId) {
        UserProject userProject = userProjectRepository.findById(userProjectId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Project Not Found"));
        return modelMapper.map(userProject, UserProjectDto.class);
    }

    @Override
    public List<UserProjectDto> getAllUserProjects() {
        return List.of();
    }
}
