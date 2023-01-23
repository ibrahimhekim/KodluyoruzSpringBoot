package com.ibrahim.springMongo.repository;

import com.ibrahim.springMongo.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial,String> {
    //Mongodb içerisindeki crud işlemlerine ulaşabilmek için oluşturduk. hybernate yapıyor.

}
