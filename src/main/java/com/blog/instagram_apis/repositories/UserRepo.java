package com.blog.instagram_apis.repositories;

import com.blog.instagram_apis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    public User findById(Integer id);
}
