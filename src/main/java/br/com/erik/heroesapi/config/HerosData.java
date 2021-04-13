package br.com.erik.heroesapi.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static br.com.erik.heroesapi.constants.HerosConstant.ENDPOINT_DYNAMO;
import static br.com.erik.heroesapi.constants.HerosConstant.REGION_DYNAMO;


public class HerosData {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_table");

        Item hero = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", " Mulher Maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 3);

        PutItemOutcome outcome = table.putItem(hero);
    }
}
