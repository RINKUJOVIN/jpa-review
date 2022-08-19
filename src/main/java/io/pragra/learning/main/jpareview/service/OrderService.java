package io.pragra.learning.main.jpareview.service;

import io.pragra.learning.main.jpareview.entity.Order;
import io.pragra.learning.main.jpareview.exceptions.OrderNotFoundException;
import io.pragra.learning.main.jpareview.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo repo;

    public Order createOrder(Order o){

        return this.repo.save(o);
    }


    public List<Order> createMany(List<Order>orders){

        return this.repo.saveAll(orders);
    }


    public Order findById(String uuidString){
       UUID uuid = UUID.fromString(uuidString);
        Optional<Order>byId=repo.findAll().stream().filter(o->o.getId().equals(uuid)).findFirst();
       return byId.orElseThrow(()-> new OrderNotFoundException("Order for UUID doesnt exist"));

    }


    public List<Order>findAll(){

        return repo.findAll();
    }
}
