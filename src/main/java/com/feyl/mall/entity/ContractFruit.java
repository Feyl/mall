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
 * 合同水果商品关系表
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("contract_fruit")
@ApiModel(value="ContractFruit对象", description="合同水果商品关系表")
public class ContractFruit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同水果关联ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同表合同ID")
    @TableField("contract_id")
    private Long contractId;

    @ApiModelProperty(value = "水果表水果ID")
    @TableField("fruit_id")
    private Long fruitId;

    @ApiModelProperty(value = "水果数量")
    @TableField("fruit_number")
    private Integer fruitNumber;

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
