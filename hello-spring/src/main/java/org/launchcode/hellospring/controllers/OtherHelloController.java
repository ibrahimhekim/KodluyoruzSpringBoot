package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hii")
public class OtherHelloController {
    @GetMapping("goodbyee")     //hii/goodbyee
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hii/ibrahim with path
    @GetMapping("{name}")
    public String hi(@PathVariable String name){
        return "Hi, " + name + "!";
    }

//---------------------------------------------------------------------------------------------------------

    //Handles request of the form hii/whatsupp?name=ibrahim with param
    @GetMapping("whatsupp")
    public String whatsup(@RequestParam String name){
        return "What's up, " + name + "!";
    }

    @GetMapping("whatsupformm")     //hii/whatsupformm
    public String whatsupForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'whatsupp'>" + //submit a request to /whatsup
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

//-----------------------------------------------------------------------------------------------------------
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloo") //hii/helloo?name=ibrahim
    public String hello(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("helloformm")       //hii/helloformm
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'helloo' method = 'post'>" + //submit a request to /whatsup
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
