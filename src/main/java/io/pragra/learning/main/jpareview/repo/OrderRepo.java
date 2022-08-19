package io.pragra.learning.main.jpareview.repo;

import io.pragra.learning.main.jpareview.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderRepo extends JpaRepository<Order, UUID> {
}
