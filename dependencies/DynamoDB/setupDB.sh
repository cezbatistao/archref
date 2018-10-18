#!/bin/bash

aws dynamodb create-table --table-name sample-app-product --attribute-definitions AttributeName=Id,AttributeType=S --key-schema AttributeName=Id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://172.17.0.1:8000 --region us-east-1
aws dynamodb batch-write-item --request-items file://tables/Product/sample-app-product.json --endpoint-url http://172.17.0.1:8000 --region us-east-1

aws dynamodb create-table --table-name sample-app-stock --attribute-definitions AttributeName=Id,AttributeType=S --key-schema AttributeName=Id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://172.17.0.1:8000 --region us-east-1
aws dynamodb batch-write-item --request-items file://tables/Stock/sample-app-stock.json --endpoint-url http://172.17.0.1:8000 --region us-east-1