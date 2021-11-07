package com.feyl.mall.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/7 18:58
 */
@Data
public class ProductVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String image;

    private BigDecimal price;

    private String locality;

    private Integer status;

    private Date createTime;

}
