package com.camunda.academy.service;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;

public class CreditCardServiceHandler implements JobHandler {
  private final CreditCardService creditCardService;

  public CreditCardServiceHandler() {
    CreditCardService creditCardService = new CreditCardService();
    this.creditCardService = creditCardService;
  }

  @Override
  public void handle(JobClient client, ActivatedJob job) throws Exception {
    creditCardService.chargeCreditCard();
    client.newCompleteCommand(job.getKey()).send().join();
  }
}
