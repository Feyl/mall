package com.feyl.mall.entity;

import java.math.BigDecimal;
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
 * 合同表
 * </p>
 *
 * @author feyl
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("contract")
@ApiModel(value="Contract对象", description="合同表")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同号")
    @TableField("barcode")
    private String barcode;

    @ApiModelProperty(value = "0：省内/1：省外")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "零售商表零售商ID")
    @TableField("retailer_id")
    private Long retailerId;

    @ApiModelProperty(value = "合同金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "支付方式：0未支付/1微信支付/2支付宝")
    @TableField("payment")
    private Integer payment;

    @ApiModelProperty(value = "订单状态：0待付款/1待发货/2已发货/3待收货/4已完成/5已关闭")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "备注信息")
    @TableField("remark")
    private String remark;

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
