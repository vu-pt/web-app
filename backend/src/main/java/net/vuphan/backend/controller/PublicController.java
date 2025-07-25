package net.vuphan.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/public")
@AllArgsConstructor
public class PublicController {
    
    private final UserService userService;
    
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto user) {
        return userService.createUser(user);
    }
}
