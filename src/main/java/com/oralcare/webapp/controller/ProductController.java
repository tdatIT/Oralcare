package com.oralcare.webapp.controller;

import com.oralcare.webapp.variable.VariableScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping(value = "/san-pham")
    public String getProductList(ModelMap modelMap){
        modelMap.addAttribute("count", VariableScope.count_request);
        return "product";
    }
}
