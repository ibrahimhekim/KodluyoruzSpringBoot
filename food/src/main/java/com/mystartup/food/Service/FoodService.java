package com.mystartup.food.Service;

import com.mystartup.food.Model.Food;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class FoodService {
    public Food[] getFoods(){
        Food[] foods = {new Food("makarna",6.3), new Food("domates",10.8), new Food("biber",17.0)};
        return foods;
    }
}
