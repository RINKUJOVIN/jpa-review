package io.pragra.learning.main.jpareview.service;

import io.pragra.learning.main.jpareview.entity.Review;
import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.repo.ReviewRepo;
import io.pragra.learning.main.jpareview.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final UserService service;

    private final ReviewRepo repo;

    public Review createReview(Review review,long userId) {
        System.out.println("nimisha added print msg");

        Optional<User> userOptional = service.getById(userId);
        Review out = null;
        if (userOptional.isPresent()) {
             out = repo.save(review);
            User user = userOptional.get();
            user.getReviews().add(out);
            service.upDateUser(user);
        }
        return out;

    }
    public Review upDateReview(Review review){

        return  repo.save(review);
    }
    public List<Review> getAll(){

        return repo.findAll();
    }
    public Optional<Review> getById(long id){

        return repo.findById(id);
    }
    //public void deleteById(long id){
       // this.repo.deleteById(id);
    }


