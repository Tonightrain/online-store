package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.Service.OrderService;
import com.thoughtworks.rslist.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity getOrderList(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size) {
        return ResponseEntity.ok(orderService.getOrderList(page, size));
    }
}
