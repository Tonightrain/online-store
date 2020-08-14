package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.Service.ProductService;
import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.exception.InvalidParamException;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getProductList(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size){
        return ResponseEntity.ok(productService.getProductList(page,size));
    }

    @PostMapping("/product/add")
    public ResponseEntity addOneProduct(@RequestBody @Valid Product product){
        boolean flag = productService.addOneProduct(product);
        return  flag?ResponseEntity.created(null).build() : ResponseEntity.badRequest().build();
    }

}
