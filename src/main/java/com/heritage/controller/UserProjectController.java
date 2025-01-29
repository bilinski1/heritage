package com.heritage.controller;

import com.heritage.dto.UserProjectDto;
import com.heritage.services.UserProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projects")
public class UserProjectController {

    private UserProjectService userProjectService;

    public UserProjectController(UserProjectService userProjectService) {
        this.userProjectService = userProjectService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserProjectDto> addProject(@RequestBody UserProjectDto userProjectDto) {
        UserProjectDto savedProject = userProjectService.addUserProject(userProjectDto);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserProjectDto> getProject(@PathVariable("id") Long projectId) {
        UserProjectDto userProjectDto = userProjectService.getUserProject(projectId);
        return ResponseEntity.ok(userProjectDto);
    };




}
