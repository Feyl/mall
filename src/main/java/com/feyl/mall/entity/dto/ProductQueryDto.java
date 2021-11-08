package com.feyl.mall.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/8 15:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductQueryDto {

    private static final long serialVersionUID = 1L;

    private String name;

    private BigDecimal lowerPrice;

    private BigDecimal upperPrice;

    private String locality;

    private Integer status;

    private Date startTime;

    private Date endTime;

}
