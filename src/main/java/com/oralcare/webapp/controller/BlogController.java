package com.oralcare.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/bai-viet")
public class BlogController {
    @GetMapping(value = "/danh-rang-thuong-ngay-lieu-da-du")
    public String getBlog1(ModelMap modelMap){
        return "thay-ban-chay";
    }
}
