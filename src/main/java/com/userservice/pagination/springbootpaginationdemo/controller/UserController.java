package com.userservice.pagination.springbootpaginationdemo.controller;

import com.userservice.pagination.springbootpaginationdemo.entity.User;
import com.userservice.pagination.springbootpaginationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/search")
    public ResponseEntity<List<User>> search(@RequestParam(required = false) String first_name,
                                             @RequestParam(required = false) String last_name,
                                             @RequestParam(required = false) String email,
                                             Pageable pageable){
        List<User> users=userService.search(first_name,last_name,email,pageable ) ;
        return  ResponseEntity.ok(users);
    }


}
