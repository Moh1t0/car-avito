package com.javaacademy.car_avito;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Announcement {
    private Integer id;
    private String brandName;
    private String color;
    private BigDecimal price;
}
