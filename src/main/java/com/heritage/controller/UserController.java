package com.heritage.controller;

import com.heritage.dto.UserDto;
import com.heritage.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{publicId}")
    public ResponseEntity<UserDto> getUserByUserId(@PathVariable String publicId) {
        return ResponseEntity.ok(userService.getUserByUserId(publicId));
    }

    @PutMapping("/{publicId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String publicId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(publicId, userDto));
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity<Void> deleteUserByPublicId(@PathVariable String publicId) {
        userService.deleteUser(publicId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi User");
    }
}
