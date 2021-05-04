package com.example

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import io.micronaut.context.annotation.Factory
import io.micronaut.security.authentication.UserDetails
import io.micronaut.security.oauth2.endpoint.token.response.OpenIdClaims
import io.micronaut.security.oauth2.endpoint.token.response.OpenIdTokenResponse
import io.micronaut.security.oauth2.endpoint.token.response.OpenIdUserDetailsMapper
import javax.inject.Named
import javax.inject.Singleton


@Singleton
@Named("google")
class GoogleUserDetailsMapper(private val dynamoDB: AmazonDynamoDB) : OpenIdUserDetailsMapper {

    override fun createUserDetails(providerName: String, tokenResponse: OpenIdTokenResponse, openIdClaims: OpenIdClaims): UserDetails {
        println(dynamoDB.toString())
        return UserDetails(providerName, emptyList())
    }
}

@Factory
class AmazonDynamoDBFactory {
    @Singleton
    fun getAmazonDynamoDb(): AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-1").build()
}
