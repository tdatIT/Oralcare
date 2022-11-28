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
        return "blog1";
    }
    @GetMapping(value = "/su-dung-chi-nha-khoa")
    public String getBlog2(ModelMap modelMap){
        return "blog3";
    }
    @GetMapping(value = "/so-sanh-2-loai-ban-chay")
    public String getBlog3(ModelMap modelMap){
        return "blog2";
    }
    @GetMapping(value = "/su-dung-kem-danh-rang")
    public String getBlog4(ModelMap modelMap){
        return "blog4";
    }
}
