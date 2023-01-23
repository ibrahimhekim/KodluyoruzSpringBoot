package com.hekim.sosyalMedya.repository;

import com.hekim.sosyalMedya.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SMRepository extends MongoRepository<User,String> {
    User findByfirstName(String firstname);



}
