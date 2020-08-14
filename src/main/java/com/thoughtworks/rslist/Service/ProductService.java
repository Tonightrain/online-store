package com.thoughtworks.rslist.Service;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductList(Integer page, Integer size) {
        List<ProductEntity> productEntities;
        if (page!=null&&size!=null&&page>0&&size>0){
            Pageable pageable = PageRequest.of(page-1,size);
            productEntities = productRepository.findAll(pageable).getContent();
        }else {
            productEntities = productRepository.findAll();
        }
        return productEntities.stream().map(
                item ->Product.builder().proName(item.getProName()).price(item.getPrice())
                        .unit(item.getUnit()).url(item.getUrl()).build()).collect(Collectors.toList());
    }
}
