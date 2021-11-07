package com.feyl.mall.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/8 0:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailerVO {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String telephone;

    private String postalCode;

    private String address;

    private Integer status;

    private Date createTime;

}
