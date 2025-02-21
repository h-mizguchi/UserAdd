package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 削除フラグが 0 のユーザーを取得するメソッド
    public List<User> getAllActiveUser() {
        return userRepository.findByDeleteFlag(0);
    }
}
