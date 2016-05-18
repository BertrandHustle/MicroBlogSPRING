package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MicroBlogSpringController {

    @Autowired
    MicroBlogSpringInterface microBlogSpringInterface;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String webRoot(Model model, HttpSession session){

        model.addAttribute("userName", session.getAttribute("userName"));
        return "home";

    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String userName, HttpSession session){

        session.setAttribute("userName", userName);
        return "redirect:/";

    }

}
