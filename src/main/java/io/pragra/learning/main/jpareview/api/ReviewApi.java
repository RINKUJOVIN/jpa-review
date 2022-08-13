package io.pragra.learning.main.jpareview.api;

import io.pragra.learning.main.jpareview.entity.Review;
import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.service.ReviewService;
import io.pragra.learning.main.jpareview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequiredArgsConstructor
    public class ReviewApi {

        private final ReviewService service;
        @PostMapping("/user/{id}/review")
        public Review createOne(@RequestBody Review review,@PathVariable long id) {
            return this.service.createReview(review,id);

        }
        @PutMapping("/user/{id}/review")
        public Review update(@RequestBody Review review,@PathVariable long id) {
            return this.service.createReview(review,id);

        }
        @GetMapping("/review")
        public List<Review> getAll() {
            return this.service.getAll();

        }
        @GetMapping("/review/{id}")
        public Optional<Review> getAll(@PathVariable long id) {
            return this.service.getById(id);

        }

       // @DeleteMapping("/review/{id}")
       // public void delete(@PathVariable long id)  {
          //  this.service.deleteById(id);

        }


