package io.pragra.learning.main.jpareview.repo;

import io.pragra.learning.main.jpareview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {

}
