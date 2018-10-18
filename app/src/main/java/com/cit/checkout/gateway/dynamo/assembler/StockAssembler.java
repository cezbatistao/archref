package com.cit.checkout.gateway.dynamo.assembler;

import com.cit.checkout.domain.Stock;
import com.cit.checkout.gateway.dynamo.model.ProductModel;
import com.cit.checkout.gateway.dynamo.model.StockModel;

public class StockAssembler {

    public static Stock assemble(StockModel stockModel, ProductModel productModel) {
        return Stock.builder()
                .id(productModel.getId())
                .product(ProductAssembler.assemble(productModel))
                .total(stockModel.getTotal())
                .build();
    }
}
