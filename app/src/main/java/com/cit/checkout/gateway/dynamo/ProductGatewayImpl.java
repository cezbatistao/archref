package com.cit.checkout.gateway.dynamo;

import com.cit.checkout.domain.Product;
import com.cit.checkout.domain.exception.ValidationException;
import com.cit.checkout.gateway.ProductGateway;
import com.cit.checkout.gateway.dynamo.assembler.ProductAssembler;
import com.cit.checkout.gateway.dynamo.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProductGatewayImpl implements ProductGateway {

    private ProductRepository productRepository;

    public ProductGatewayImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByCode(String code) {
        Optional<ProductModel> productModel = productRepository.findById(UUID.fromString(code));
        return ProductAssembler.assemble(productModel.orElseThrow(() -> new ValidationException("Product Not Found")));
    }
}
