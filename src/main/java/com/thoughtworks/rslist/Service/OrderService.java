package com.thoughtworks.rslist.Service;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrderList(Integer page, Integer size) {
        List<OrderEntity> orderEntities;
        if (page!=null&&size!=null&&page>0&&size>0){
            Pageable pageable = PageRequest.of(page-1,size);
            orderEntities = orderRepository.findAll(pageable).getContent();
        }else {
            orderEntities = orderRepository.findAll();
        }
        return orderEntities.stream().map(
                item ->Order.builder().orderName(item.getOrderName()).orderPrice(item.getOrderPrice())
                .number(item.getNumber()).orderUnit(item.getOrderUnit()).build()).collect(Collectors.toList());
    }
}
