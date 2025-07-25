package net.vuphan.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.vuphan.backend.datamodel.dto.ConfigDto;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/config")
public class ConfigController {
    @GetMapping
    public ConfigDto getAppConfig() {
        return new ConfigDto("1.0.0");
    }
    
}
