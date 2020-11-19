package com.santos.springbool.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.santos.springbool.domain.User;
import com.santos.springbool.dto.UserDTO;
import com.santos.springbool.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = service.findAll()
                                    .stream()
                                    .map(user -> new UserDTO(user))
                                    .collect(Collectors.toList());
                                    
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        UserDTO user = new UserDTO(obj);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
