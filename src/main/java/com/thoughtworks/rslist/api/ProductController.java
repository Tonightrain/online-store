package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.Service.ProductService;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
