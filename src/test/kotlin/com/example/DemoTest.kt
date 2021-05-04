package com.example
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class DemoTest(private val embeddedServer: EmbeddedServer) {

    @MockBean(AmazonDynamoDB::class)
    fun amazonDynamoDB(): AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-1").build()

    @Test
    fun testItWorks() {
        Assertions.assertTrue(embeddedServer.isRunning)
    }

}
