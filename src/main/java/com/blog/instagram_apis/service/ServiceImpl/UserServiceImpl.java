package com.blog.instagram_apis.service.ServiceImpl;

import com.blog.instagram_apis.entity.User;
import com.blog.instagram_apis.payload.UserDto;
import com.blog.instagram_apis.repositories.UserRepo;
import com.blog.instagram_apis.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

    @Service
    public class UserServiceImpl implements UserService {

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
        public UserDto updateUser(UserDto userDto, UUID id) {
            Optional<User> userOptional = userRepo.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setFullname(userDto.getFullname());
                user.setUsername(userDto.getUsername());
                user.setPassword(userDto.getPassword());
                userRepo.save(user); // bad me password update change kar denge abhi bas crud operation hai ye    OK BHAI
                return modelMapper.map(user, UserDto.class);
            } else {
                return null;
            }
        }

        @Override
        public UserDto getUser(UUID id) {
            Optional<User> userOptional = userRepo.findById(id);
            return userOptional.map(user -> modelMapper.map(user, UserDto.class))
                    .orElse(null); // ye samajh na aye to poochh liyo
        }

        @Override
        public void deleteUser(UUID id) {

            if(userRepo.existsById(id)) {
                userRepo.deleteById(id);
            }
            else{
                throw new RuntimeException("User not found");
            }
        }

        @Override
        public List<UserDto> getAllUsers() // iska return type list hoga kyuki more than 1 users return hore hai
        {
            List<User> users = userRepo.findAll();
            return users.stream()
                    .map(user -> modelMapper.map(user, UserDto.class))
                    .collect(Collectors.toList());
        }
    }
