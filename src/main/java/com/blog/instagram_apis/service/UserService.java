package com.blog.instagram_apis.service;

import com.blog.instagram_apis.payload.UserDto;

public interface UserService {
    // create
    UserDto createUser(UserDto userDto) ;
    //update
    UserDto updateUser(UserDto userDto,Integer id);
    // get User
    UserDto getUser(Integer id);
    // delete user
    void deleteUser(Integer id);
    // get all users
    UserDto getAllUsers();
}
