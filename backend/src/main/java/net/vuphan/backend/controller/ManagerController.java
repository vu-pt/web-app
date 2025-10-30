package net.vuphan.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/manager")
@AllArgsConstructor
public class ManagerController {
    
    private final UserService userService;
    
    @RequestMapping("/test")
    String home() {
        return "This is manager";
    }

    @GetMapping("/list")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
