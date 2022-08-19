package io.pragra.learning.main.jpareview.api;

import io.pragra.learning.main.jpareview.dtos.ErrorDto;
import io.pragra.learning.main.jpareview.entity.Order;
import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.exceptions.OrderNotFoundException;
import io.pragra.learning.main.jpareview.service.OrderService;
import io.pragra.learning.main.jpareview.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@RestController
    @RequiredArgsConstructor
    @RequestMapping("/api")
    @Slf4j
        public class OrderApi {
        private final OrderService service;


        @PostMapping("/order")
        public ResponseEntity<Order> createOrder(@RequestBody Order order, @RequestHeader("X-MARKET") String market) {
            log.info("GOT HEADER{}", market);
            Order serviceOrder = service.createOrder(order);
            return ResponseEntity.status(201).header("X-COMPLETE", "true").body(serviceOrder);

        }

        @RequestMapping(value = "/order", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity<?> getAll() {
            return ResponseEntity.status(201).header("X-COMPLETE", "true").body(service.findAll());

        }


        @GetMapping(value= "/order/{uuid}",produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity<?>getAll(@PathVariable String uuid) {
            try {
                Order order = service.findById(uuid);
                return ResponseEntity.ok().body(order);
            } catch (OrderNotFoundException ex) {
                return ResponseEntity.status(404).body(
                        ErrorDto.builder()
                                .errCode("AP404")
                                .apiCode("ORDER101")
                                .errMessage(ex.getMessage())
                                .timeStamp(Instant.now()).build());


            }

        }}




