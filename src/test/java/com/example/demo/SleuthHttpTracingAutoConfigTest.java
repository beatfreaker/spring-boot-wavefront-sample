package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import brave.http.HttpTracing;
import brave.httpclient.TracingHttpClientBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.sleuth.autoconfig.brave.instrument.web.client.BraveWebClientAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SleuthHttpTracingAutoConfigTest {

  @Autowired
  ApplicationContext applicationContext;

  @Test
  void shouldAutoConfigureTracingHttpClientBuilder() {
    assertDoesNotThrow(() -> applicationContext.getBean(HttpTracing.class));
    assertDoesNotThrow(() -> applicationContext.getBean(HttpClientBuilder.class));
    assertDoesNotThrow(() -> applicationContext.getBean(BraveWebClientAutoConfiguration.class));
    assertTrue(applicationContext.getBean(
        HttpClientBuilder.class) instanceof TracingHttpClientBuilder);
  }
}
