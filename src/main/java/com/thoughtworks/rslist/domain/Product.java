package com.thoughtworks.rslist.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @NotNull
    private String proName;

    @NotNull
    @Pattern(regexp = "^[0-9]*$")
    private Integer price;

    @NotNull
    private String unit;

    @NotNull
    private String url;

}