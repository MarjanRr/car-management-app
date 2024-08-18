package com.car_rental_managment_app.endpoint;

import com.car_rental_managment_app.entities.UserEntity;
import com.car_rental_managment_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserEndpoint {

    @Autowired UserService userService;


    @PostMapping("/createUser")
    public  ResponseEntity<UserEntity> createdUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long userId){
      Optional<UserEntity>  getUserById= userService.findById(userId);
        return new  ResponseEntity<>(getUserById,HttpStatus.OK);
    }
    @PostMapping("/updateUser/{userId}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user,@PathVariable Long userId){
        UserEntity updatedUser=userService.updateUser(user,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
