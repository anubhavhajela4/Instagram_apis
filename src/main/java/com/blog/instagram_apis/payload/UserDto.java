package com.blog.instagram_apis.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID id; // not sure if i should take integer here or uuid (please check) UUID HI SAHI HAI.
    @NotBlank(message = "username should not be blank")
    private String username;
    @NotBlank(message = "fullname should not be blank")
    private String fullname;
    @Length(min = 5)
    private String password;
    @Email
    private String email;
    private String profilePicture;
    private String bio;

}
