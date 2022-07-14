package io.camunda.getstarted;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetDebtDataWorker implements JobHandler {

  private final static Logger LOG = LoggerFactory.getLogger(GetDebtDataWorker.class);

  @Override
  @ZeebeWorker(type = "getDebtData")
  public void handle(JobClient client, ActivatedJob job) throws Exception {
    final Integer clientId = (Integer) job.getVariablesAsMap().get("clientId");
    LOG.info("Calculating debt for client id: {}", clientId);
    boolean applicable = clientId == 2;
    job.getVariablesAsMap().put("applicable", applicable);
    LOG.info("Set variable applicable to : {}", applicable);
    Map<String, Object> variables = new HashMap<>();
    variables.put("applicable", applicable);
    client
            .newCompleteCommand(job)
            .variables(variables)
            .send();
  }
}
