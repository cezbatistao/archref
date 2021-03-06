package com.cit.checkout.gateways.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.cit.checkout.config.dynamodb.ListPurchaseModelMarshaller;
import com.cit.checkout.config.dynamodb.UUIDMarshaller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "sample-app-order")
public class OrderModel implements Serializable {

    @Id
    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBMarshalling(marshallerClass = UUIDMarshaller.class)
    private UUID id;

    @DynamoDBAttribute(attributeName = "OrderNumber")
    private Long orderNumber;

    @DynamoDBAttribute(attributeName = "Username")
    private String username;

    @DynamoDBMarshalling(marshallerClass = ListPurchaseModelMarshaller.class)
    private List<PurchaseModel> items;

    @DynamoDBAttribute(attributeName = "Value")
    private BigDecimal value;

}
