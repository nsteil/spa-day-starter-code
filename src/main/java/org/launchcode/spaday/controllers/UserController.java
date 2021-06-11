package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("add")
    public String displayAddUserForm(@RequestParam(required = false) String username,@RequestParam(required = false) String email, Model model) {
        if (username != null){
            model.addAttribute("username",username);
            model.addAttribute("email",email);
           // model.addAttribute("error",
        }
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if (user.verifyPassword(verify)){
            model.addAttribute("user",user);
            return "user/index";
        } else {
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            model.addAttribute("error", true);
            return "user/add";
        }
    }
}
