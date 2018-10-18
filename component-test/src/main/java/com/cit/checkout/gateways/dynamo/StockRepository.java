package com.cit.checkout.gateways.dynamo;

import com.cit.checkout.gateways.dynamo.model.StockModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@EnableScan
public interface StockRepository extends CrudRepository<StockModel, UUID> {

    StockModel findByProductId(UUID productId);

}
