package com.cit.checkout.gateway.dynamo.assembler;

import com.cit.checkout.domain.Purchase;
import com.cit.checkout.gateway.dynamo.model.PurchaseModel;

import java.math.RoundingMode;
import java.util.UUID;

public class PurchaseAssembler {

    public static Purchase assemble(PurchaseModel purchaseModel) {
        return Purchase.builder()
                .productCode(purchaseModel.getProductId().toString())
                .quantity(purchaseModel.getQuantity())
                .value(purchaseModel.getValue().setScale(2, RoundingMode.CEILING))
                .build();
    }

    public static PurchaseModel assemble(Purchase purchase) {
        return PurchaseModel.builder()
                .productId(UUID.fromString(purchase.getProductCode()))
                .quantity(purchase.getQuantity())
                .value(purchase.getValue().setScale(2, RoundingMode.CEILING))
                .build();
    }
}
