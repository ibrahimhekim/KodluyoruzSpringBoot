package com.mystartup.food.Controller;

import com.mystartup.food.Model.Food;
import com.mystartup.food.Service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FoodController {
    private FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("message", "My dear subscribes, i am from the food controller");

        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }
}
