package com.camunda.academy.client;


import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;
import io.github.cdimascio.dotenv.Dotenv;

public class Client {

    private final ZeebeClient zeebeClient;

    public Client() {
        // Load environment variables
        Dotenv dotenv = Dotenv.load();
        String zeebeAddress = dotenv.get("ZEEBE_ADDRESS");
        String zeebeClientID = dotenv.get("ZEEBE_CLIENT_ID");
        String zeebeClientSecret = dotenv.get("ZEEBE_CLIENT_SECRET");
        String zeebeAuthorizationServerURL = dotenv.get("ZEEBE_AUTHORIZATION_SERVER_URL");
        String zeebeTokenAudience = dotenv.get("ZEEBE_TOKEN_AUDIENCE");

        OAuthCredentialsProvider credentialsProvider = new OAuthCredentialsProviderBuilder()
                .authorizationServerUrl(zeebeAuthorizationServerURL)
                .audience(zeebeTokenAudience)
                .clientId(zeebeClientID)
                .clientSecret(zeebeClientSecret)
                .build();

        zeebeClient = ZeebeClient.newClientBuilder()
                .gatewayAddress(zeebeAddress)
                .credentialsProvider(credentialsProvider)
                .build();
    }

    public ZeebeClient getZeebeClient() {
        return zeebeClient;
    }

    public void closeZeebeClient() {
        if (zeebeClient != null) {
            zeebeClient.close();
        }
    }
}
