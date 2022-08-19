package io.pragra.learning.main.jpareview.api;

import io.pragra.learning.main.jpareview.dtos.GitHubUser;
import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApi {
    private final UserService service;
@PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.service.createUser(user);

    }
    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return this.service.createUser(user);

    }
    @GetMapping("/user")
    public List<User> getAll(@RequestParam(name="lastName",required = false)Optional<String>lastName) {
    if(lastName.isPresent()){
        return this.service.getAllByLastName(lastName.get());
    }
        return this.service.getAll();

    }
    @GetMapping("/user/{id}")
    public Optional<User> getOne(@PathVariable long id) {
        return this.service.getById(id);

    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable long id)  {
         this.service.deleteById(id);

    }
    @GetMapping("/count")
    public Map<String,Integer>getAll(){

    return service.getAllUser();
    }

@GetMapping("/user/github/{login}")
    public GitHubUser getUser(@PathVariable("login")String login){
    return this.service.getGitHubUser(login);
    }
    @PostMapping("/user/github")
    public Map<String,String> getUser(@RequestBody()User user) throws URISyntaxException{
        return this.service.doPost(user);
    }
}