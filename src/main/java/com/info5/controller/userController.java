package com.info5.controller;

import com.info5.UserDto;
import com.info5.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class userController {
    UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }
//url=http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
        UserDto dto = userService.saveData(userDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto>getData(@PathVariable("id")long id){
        UserDto dataById = userService.findDataById(id);
        return new ResponseEntity<>(dataById,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteByIdData(@PathVariable("id")long Id){
        userService.DeleteByid(Id);
    }
}
