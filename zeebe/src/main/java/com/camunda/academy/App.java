package com.camunda.academy;

import java.time.Duration;

import com.camunda.academy.client.Client;
import com.camunda.academy.service.CreditCardServiceHandler;
import io.camunda.zeebe.client.ZeebeClient;

public class App {
  public static void main(String[] args) {
    Client client = new Client();
    ZeebeClient zeebeClient = client.getZeebeClient();
    try {
      zeebeClient.newWorker()
          .jobType("chargeCreditCard")
          .handler(new CreditCardServiceHandler())
          .timeout(Duration.ofSeconds(10).toMillis())
          .open();
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      client.closeZeebeClient();
    }
  }
}
