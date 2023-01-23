package com.hekim.sosyalMedya.controller;

import com.hekim.sosyalMedya.entity.User;
import com.hekim.sosyalMedya.repository.SMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/SM")
public class SMController {
    @Autowired
    SMRepository smRepository;

    private List<User> users = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList=smRepository.findAll();

        return new ResponseEntity<>(userList,OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User user = smRepository.findById(id).get();
        return new ResponseEntity<>(user, OK);

        //User user=smRepository.findByfirstName(firstName);
          //  return new ResponseEntity<>(user,OK);

        //User newUser=getUserByName(firstName);
        //return new ResponseEntity<>(getUserByName(firstName),OK);
    }

    @PutMapping("/{firstName}")
    public ResponseEntity<User> changeUser(@PathVariable String firstName, @RequestBody User newUser){
        //User oldUser =getUserByName(firstName);
        User oldUser=smRepository.findByfirstName(firstName);
        oldUser.setFirstName(newUser.getFirstName());

        oldUser.setLastName(newUser.getLastName());

        oldUser.setPassword(newUser.getPassword());

        smRepository.save(oldUser);

        return new ResponseEntity<>(oldUser,OK);
    }

    @PatchMapping("/{firstName}")
    public ResponseEntity<User> changeUserWithPatch(@PathVariable String firstName, @RequestBody User newUser){
        //User oldUser =getUserByName(firstName);
        User oldUser=smRepository.findByfirstName(firstName);
        oldUser.setFirstName(newUser.getFirstName());

        oldUser.setLastName(newUser.getLastName());

        oldUser.setPassword(newUser.getPassword());

        smRepository.save(oldUser);

        return new ResponseEntity<>(oldUser,OK);
    }

    @DeleteMapping("/{firstName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String firstName){
        users.remove(getUserByName(firstName));

        return new ResponseEntity<>(OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        try {
            User reqUser =smRepository.save(new User(user.getFirstName(), user.getLastName(), user.getPassword()));
            users.add(user);

            return new ResponseEntity<>(reqUser, CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, INTERNAL_SERVER_ERROR);
        }
    }

    private User getUserByName(String name){
        return users.stream()
                .filter(users -> users.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
