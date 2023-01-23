package com.ibrahim.springMongo.controller;


import com.ibrahim.springMongo.entity.Tutorial;
import com.ibrahim.springMongo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//rest api kullanılacağını belirler
@RestController
//isteklerin url de hangi yol üzerinden gideceğini belirler
@RequestMapping("/ibrahim")
public class TutorialController {
    //injection olayını yapıyor
    @Autowired
    TutorialRepository tutorialRepository;

    //post işleminde bu metodun çalışacağını belirtir
    @PostMapping
    //Requestbody ile parametreler HTTP istek gövdesine bağlanır
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        try {
            Tutorial reqTutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(),true));
            return new ResponseEntity<>(reqTutorial, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
