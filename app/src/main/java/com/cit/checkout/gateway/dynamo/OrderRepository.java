package com.cit.checkout.gateway.dynamo;

import com.cit.checkout.gateway.dynamo.model.OrderModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@EnableScan
public interface OrderRepository extends CrudRepository<OrderModel, UUID> {

    List<OrderModel> findAllByUsername(String username);

}
