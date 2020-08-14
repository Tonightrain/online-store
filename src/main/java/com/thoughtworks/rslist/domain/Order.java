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
@AllArgsConstructor
public class Order {

    @NotNull
    private String orderName;

    @NotNull
    private Integer orderPrice;

    @NotNull
    private Integer number;

    @NotNull
    private String orderUnit;

}
