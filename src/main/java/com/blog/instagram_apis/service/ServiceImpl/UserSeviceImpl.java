package com.blog.instagram_apis.service.ServiceImpl;

import com.blog.instagram_apis.entity.User;
import com.blog.instagram_apis.payload.UserDto;
import com.blog.instagram_apis.repositories.UserRepo;
import com.blog.instagram_apis.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User user1 = userRepo.save(user);
        return modelMapper.map(user1, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = userRepo.findById(id);
        user.setFullname(userDto.getFullname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepo.save(user); // bad me password update change kar denge abhi bas crud operation hai ye
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUser(Integer id) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public UserDto getAllUsers() {
        return null;
    }
}
