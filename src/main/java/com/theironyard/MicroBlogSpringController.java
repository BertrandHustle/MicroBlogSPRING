package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MicroBlogSpringController {

    @Autowired
    MicroBlogSpringInterface microBlogSpringInterface;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String login(Model model, HttpSession session){

        //String userName = session.getAttribute("userName");
        return "home";

    }


}
