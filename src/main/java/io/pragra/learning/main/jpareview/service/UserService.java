package io.pragra.learning.main.jpareview.service;

import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.exceptions.BadUserArgumentException;
import io.pragra.learning.main.jpareview.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user){
      /*  if(user.getFirstName()== null){
            throw new BadUserArgumentException("First Name Cant be Null");*/
        return  this.userRepo.save(user);
        }
    public User upDateUser(User user){
        return  this.userRepo.save(user);
    }
    public List<User> getAll(){
        return this.userRepo.findAll();
    }
    public Optional<User> getById(long id){
        return this.userRepo.findById(id);
    }
    public void deleteById(long id){
        this.userRepo.deleteById(id);
    }
   // public List<User>getAllByLastName(String lastName){
   //     return this.userRepo.findAllByLastName(lastName);
   public List<User>getAllByLastName(String lastName) {
           return this.userRepo.findAllCustom(lastName);

   }
   public Map<String,Integer> getAllUser(){
        return Collections.singletonMap("user",userRepo.getAllUserCount());

   }
    }

