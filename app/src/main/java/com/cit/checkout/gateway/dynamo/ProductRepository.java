package com.cit.checkout.gateway.dynamo;

import com.cit.checkout.gateway.dynamo.model.ProductModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@EnableScan
public interface ProductRepository extends CrudRepository<ProductModel, UUID> {
}
