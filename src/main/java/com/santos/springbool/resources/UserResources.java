package com.santos.springbool.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.santos.springbool.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Zah", "email@gmail.com");
        User user2 = new User("2", "Zah 2", "email@gmail.com2");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }
}
