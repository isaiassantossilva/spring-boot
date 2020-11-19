package com.santos.springbool.services;

import java.util.List;

import com.santos.springbool.domain.User;
import com.santos.springbool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

}
