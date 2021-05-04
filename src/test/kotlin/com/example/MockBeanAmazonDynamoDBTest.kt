package com.example
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class MockBeanAmazonDynamoDBTest(private val embeddedServer: EmbeddedServer) {

    /* AmazonDynamoDB is an interface but on 2.4.1 this mock bean used to work */
    @MockBean(AmazonDynamoDB::class)
    fun amazonDynamoDB(): AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-1").build()

    @Test
    fun testItWorks() {
        Assertions.assertTrue(embeddedServer.isRunning)
    }

}
