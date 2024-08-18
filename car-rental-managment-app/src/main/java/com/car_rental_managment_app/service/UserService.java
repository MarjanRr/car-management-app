package com.car_rental_managment_app.service;

import com.car_rental_managment_app.entities.UserEntity;
import com.car_rental_managment_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public UserEntity updateUser(UserEntity user, Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            UserEntity updateUser = userEntity.get();
            updateUser.setName(user.getName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
            updateUser.setAge(user.getAge());
            updateUser.setRole(user.getRole());
            return userRepository.saveAndFlush(updateUser);
        }
        return null;
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}