package io.pragra.learning.main.jpareview.controller;

import io.pragra.learning.main.jpareview.dtos.GitHubUser;
import io.pragra.learning.main.jpareview.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("/user/github/{login}")
    public String getUser(@PathVariable("login")String login, Model model){
        GitHubUser gitHubUser = this.service.getGitHubUser(login);
        model.addAttribute("gitHubUser",gitHubUser);
        model.addAttribute("title","Welcome to GitHub"+login);
        System.out.println("print");
        return "githubuser";

    }

}
