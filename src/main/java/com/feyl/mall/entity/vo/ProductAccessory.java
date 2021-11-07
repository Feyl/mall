package com.feyl.mall.entity.vo;

import com.feyl.mall.entity.Accessory;
import com.feyl.mall.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Feyl
 * @date 2021/11/7 15:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAccessory {
    private Product product;
    List<Accessory> accessories;
}
