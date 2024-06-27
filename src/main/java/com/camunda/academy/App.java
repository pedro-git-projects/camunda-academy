package com.camunda.academy;

import com.camunda.academy.client.Client;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.Topology;

public class App {

  public static void main(String[] args) {
    Client client = new Client();
    ZeebeClient zeebeClient = client.getZeebeClient();
    try {
      Topology topology = zeebeClient.newTopologyRequest().send().join();
      System.out.println("Topology: " + topology);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      client.closeZeebeClient();
    }
  }
}
