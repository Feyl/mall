package com.feyl.mall.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/8 20:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailerQueryDto {

    private String name;

    private String telephone;

    private String address;

    private Integer status;

    private Date startTime;

    private Date endTime;
}
