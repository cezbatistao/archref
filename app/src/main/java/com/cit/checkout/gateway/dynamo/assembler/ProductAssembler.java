package com.cit.checkout.gateway.dynamo.assembler;

import com.cit.checkout.domain.Product;
import com.cit.checkout.gateway.dynamo.model.ProductModel;

import java.math.RoundingMode;

public class ProductAssembler {

    public static Product assemble(ProductModel productModel) {
        return Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .value(productModel.getValue().setScale(2, RoundingMode.CEILING))
                .build();
    }
}
