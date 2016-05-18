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
    MicroBlogSpringRepo microBlogSpringRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String webRoot(Model model, HttpSession session){

        //used to add messages to model
        Iterable<Message> messages;
        messages = microBlogSpringRepo.findAll();

        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";

    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String userName, HttpSession session){

        session.setAttribute("userName", userName);
        return "redirect:/";

    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String message){
        Message addMessage = new Message();
        addMessage.setText(message);

        //saves new message to repo
        microBlogSpringRepo.save(addMessage);
        return "redirect:/";

    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.GET)
    public String deleteMessage(String id){

        int idInt = Integer.parseInt(id);

        //deletes message from database
        microBlogSpringRepo.delete(idInt);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.GET)
    public String editMessage(int id, String message){

        //creates new message and sets id to id of deleted message
        Message editedMessage = new Message();
        editedMessage.setText(message);
        editedMessage.setId(id);

        //deletes old message and saves new one at correct id
        microBlogSpringRepo.delete(id);
        microBlogSpringRepo.save(editedMessage);
        return "redirect:/";

    }

}
