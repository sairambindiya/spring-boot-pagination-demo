package com.userservice.pagination.springbootpaginationdemo.service;

import com.github.javafaker.Faker;
import com.userservice.pagination.springbootpaginationdemo.entity.User;
import com.userservice.pagination.springbootpaginationdemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    Faker faker=new Faker();
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insertMillionUsers() {
        for(int i=0;i<1000000;i++){
            User user=new User();
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            userRepository.save(user);
        }

    }

    public long countUsers() {
        return userRepository.count();
    }

    public ArrayList<User> search(String first_name, String last_name, String email,Pageable pageable) {
        return (ArrayList<User>) userRepository.search(first_name,last_name,email, (Pageable) PageRequest.of(0, 10));
    }
}
