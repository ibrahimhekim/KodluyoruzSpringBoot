package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //Handles request at path /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/

    //Handles request at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hi/ibrahim with path
    @GetMapping("hi/{name}")
    @ResponseBody
    public String hi(@PathVariable String name){
        return "Hi, " + name + "!";
    }

    //--------------------------------------------------------------------------------------
    //Handles request of the form /whatsup?name=ibrahim with param
    @GetMapping("whatsup")
    @ResponseBody
    public String whatsup(@RequestParam String name){
        return "What's up, " + name + "!";
    }

    @GetMapping("whatsupform")      //just /whatsupform
    @ResponseBody
    public String whatsupForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'whatsup'>" + //submit a request to /whatsup
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //----------------------------------------------------------------------------------------
    //Handles request of the form /hello?name=ibrahim with param
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hellom(@RequestParam String name, Model model){
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

    @GetMapping("helloform")            //just /helloform
    public String helloForm(Model model){
        model.addAttribute("addition", "bu yeni bir haber");
        return "form";
    }

    //-----------------------------------------------------------------------------------------
    @GetMapping("hello/{name}")     //hello/ibrahim
    public String helloAgain(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    //-----------------------------------------------------------------------------------------
    @GetMapping("hellonames")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("html");
        names.add("css");
        names.add("js");
        model.addAttribute("names", names);
        return "hellolist";
    }
}
