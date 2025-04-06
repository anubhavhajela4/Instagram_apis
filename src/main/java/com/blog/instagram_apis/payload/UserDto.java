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
    private UUID id; // UUID is correct, no need to change it to Integer.

    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotBlank(message = "Fullname should not be blank")
    private String fullname;

    @Length(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    @Email(message = "Invalid email format")
    private String email;

    private String profilePicture;
    private String bio;
}
