package com.feyl.mall.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/7 23:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessoryVO {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private BigDecimal price;

    private Date createTime;
}
