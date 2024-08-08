package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.OTPservice;
import com.example.demo.service.UserService;
import com.example.demo.service.UserserviceImp;

@Controller
public class UserController {

    String otp;

    @Autowired
    private UserserviceImp userService;

    @Autowired
    private  OTPservice otpservice;

    @GetMapping("/")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/loginotp")
    public String getOtp(@RequestParam("username")  String Username) {
        String demo = "+91"+Username;
        otp = userService.generateOTP(Username);
        otpservice.sendOtp(demo,otp);
       System.out.println(otp);
       return "OTP";
    }
    
    @GetMapping("/NewOtp")
    public String getAuthenticate(@RequestParam("NewOtp") String NewOtp) {
        if(otp.equals(NewOtp)) {
        	return "Authentication";
        }
        else {
        	return "fail";
        }
    }
    
    
}