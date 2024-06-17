package org.pathfinder.web;

import jakarta.validation.Valid;
import org.pathfinder.web.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    @GetMapping("users/register")
    public String viewRegister(){

        return "register";
    }

    @PostMapping("/users/register")
    public String doRegister(@Valid UserRegisterDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "register";
        }


        return "redirect:/users/login";
    }

    @GetMapping("/users/login")
    public String viewLogin(){
        return "login";
    }


}
