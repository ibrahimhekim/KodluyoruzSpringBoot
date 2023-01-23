package com.hekim.CityService.controller;
import com.hekim.CityService.model.City;
import com.hekim.CityService.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/cities")
public class CityController {

    private static final List<City> cities = new ArrayList<>();

    public CityController(){
        if (cities.isEmpty()){
            City istanbul = new City(new Date(),"34","Istanbul");
            City ankara = new City(new Date(),"06","Ankara");
            City samsun = new City(new Date(),"55","Samsun");

            this.cities.add(istanbul);
            this.cities.add(ankara);
            this.cities.add(samsun);
        }
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities(){

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCities(@PathVariable String id){
        City result = getCityById(id);

        return new ResponseEntity<>(result,HttpStatus.OK);
        }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCity){
        newCity.setCreateDate(new Date());
        cities.add(newCity);

        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getCities(@PathVariable String id, @RequestBody City newCity){
        City oldCity = getCityById(id);
        oldCity.setName(newCity.getName());
        oldCity.setCreateDate(new Date());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id){
        City city = getCityById(id);
        cities.remove(city);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private City getCityById(String id){
        return cities.stream()
                .filter(cities -> cities.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("City not found"));
    }
}
