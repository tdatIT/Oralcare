package com.oralcare.webapp.controller;

import com.oralcare.webapp.model.Contact;
import com.oralcare.webapp.model.CustomUserDetails;
import com.oralcare.webapp.model.User;
import com.oralcare.webapp.services.ContactSerivce;
import com.oralcare.webapp.services.EmailService;
import com.oralcare.webapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private ContactSerivce contactSerivce;

    @RequestMapping(value = {"/trang-chu", "/"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String lastname = ((CustomUserDetails) authentication.getPrincipal()).getLastName();
            modelMap.addAttribute("lastname", lastname);
        }
        return "index";
    }

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public String getRegisterPage(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            User user = new User();
            modelMap.addAttribute("register", user);
            return "register";
        } else
            return "redirect:/";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String register(ModelMap modelMap,
                           @RequestParam String lastname,
                           @RequestParam String firstname,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String address,
                           @RequestParam String status_health,
                           @RequestParam Date birthday,
                           @RequestParam String phone) {
        User user = new User();
        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setStatusHealth(status_health);
        user.setBirthday(birthday);
        user.setPhoneNumber(phone);
        if (userService.registerUser(user)) {
            return "redirect:/dang-nhap?dangky=true";
        } else
            return "redirect:/dang-ky?error=true";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String sendContact(@RequestParam String email,
                              @RequestParam String content) {
        User user = userService.findUserByUsername(email);
        Contact contact = new Contact();
        contact.setContent(content);
        contact.setEmail(email);
        if (contactSerivce.receiveContact(contact)) {
            emailService.replyMailContact(contact.getEmail());
            return "success";
        } else
            return "error";
    }
}
