package com.openclassrom.watchlist;

import com.openclassrom.watchlist.AppUser.User;
import com.openclassrom.watchlist.AppUser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class adminController {

@Autowired
private UserRepository userRepository;
    @GetMapping("/admin")
    public String admin() {

     return  "this admin page***!!!!!";

    }


    @GetMapping("/profile")
    public String profil() {

        return  "user profile pagellllllmmmmmm ";

    }


    @GetMapping("/manager")
    public String manager() {

        return  "this manager page***!!!!!";

    }

    @GetMapping("/abc1")
    public String abc() {

        return  "\n acces_abcOne \n!";

    }

    @GetMapping("/abc2")
    public String abc2() {

        return  "\n acces_abcTWO \n!";
    }






}