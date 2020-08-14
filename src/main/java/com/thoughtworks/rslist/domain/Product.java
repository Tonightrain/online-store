package com.thoughtworks.rslist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Builder
@Data
@NoArgsConstructor
public class Product {


    @NotNull
    private String proName;

    @NotNull
    private Integer price;

    @NotNull
    private String unit;

    @NotNull
    private String url;

        public Product(String proName ,Integer price, String unit,String url){
        this.proName = proName;
        this.price = price;
        this.unit = unit;
        this.url = url;
    }
}