package net.vuphan.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    
    @RequestMapping("/test")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/list")                    
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable Long id,@RequestBody UserDto userDto){
        return userService.updateUserById(id, userDto);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
