package com.cit.checkout.gateway.dynamo;

import com.cit.checkout.domain.Product;
import com.cit.checkout.domain.Stock;
import com.cit.checkout.domain.exception.ValidationException;
import com.cit.checkout.gateway.StockGateway;
import com.cit.checkout.gateway.dynamo.assembler.StockAssembler;
import com.cit.checkout.gateway.dynamo.model.ProductModel;
import com.cit.checkout.gateway.dynamo.model.StockModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockGatewayImpl implements StockGateway {

    private StockRepository stockRepository;
    private ProductRepository productRepository;

    public StockGatewayImpl(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Stock getStock(Product product) {
        StockModel stockModel = stockRepository.findByProductId(product.getId());
        Optional<ProductModel> productModel = productRepository.findById(product.getId());
        return StockAssembler.assemble(stockModel, productModel.orElseThrow(() -> new ValidationException("Product Not Found")));
    }

    @Override
    public boolean lowStock(Product product, int quantityToPurchase) {
        StockModel stockModel = stockRepository.findByProductId(product.getId());

        stockModel.setTotal(stockModel.getTotal() - 1);

        stockRepository.save(stockModel);

        return false;
    }
}
