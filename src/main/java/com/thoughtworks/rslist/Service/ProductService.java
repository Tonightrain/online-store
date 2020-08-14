package com.thoughtworks.rslist.Service;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.exception.InvalidParamException;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.criteria.CriteriaBuilder;
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

    public boolean addOneProduct(Product product){
        if (!(product.getPrice() instanceof Integer)){
            return false;
        }
        ProductEntity productEntity = ProductEntity.builder().proName(product.getProName())
                .price(product.getPrice()).unit(product.getUnit()).url(product.getUrl()).build();
        productRepository.save(productEntity);
        return true;
    }
}
