package net.vuphan.backend.datamodel.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String username;
    private String fullname;
    @JsonIgnore
    private String password;
    private Date lastLogin;
    private boolean status;
}
