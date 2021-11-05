package com.feyl.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 合同商品关系表
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("contract_product")
@ApiModel(value="ContractProduct对象", description="合同商品关系表")
public class ContractProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同商品关联ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同表合同ID")
    @TableField("contract_id")
    private Long contractId;

    @ApiModelProperty(value = "商品表商品ID")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty(value = "商品数量")
    @TableField("product_number")
    private Integer productNumber;

    @ApiModelProperty(value = "逻辑删除：0不删除/1删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
