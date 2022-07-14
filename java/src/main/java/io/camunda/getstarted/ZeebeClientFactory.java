package io.camunda.getstarted;

import io.camunda.zeebe.client.ZeebeClient;

public class ZeebeClientFactory {

  public static ZeebeClient getZeebeClient() {
    return ZeebeClient.newCloudClientBuilder()
        .withClusterId("ed2a6d84-b926-4bf9-b0c3-098ffdd38d45")
        .withClientId(".lKh~71ug-q_qlkq.z95sHwOKbH00LVw")
        .withClientSecret("CTUht2QuUJ9xOb6hZqkD4hGPkDGUCEDP4FlZjp0F2FkNgbC2KjPip57AxQj48GtB")
        .withRegion("dsm-1")
        .build();
  }

}
