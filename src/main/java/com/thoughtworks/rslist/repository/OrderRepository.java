package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity,Integer> {

    List<OrderEntity> findAll();

    Page<OrderEntity> findAll(Pageable pageable);

}