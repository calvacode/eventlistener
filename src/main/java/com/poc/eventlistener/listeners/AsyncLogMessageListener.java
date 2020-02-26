package com.poc.eventlistener.listeners;

import static java.lang.String.format;
import static java.lang.System.out;

import com.poc.eventlistener.domain.AsyncEventWrapper;
import com.poc.eventlistener.domain.Stub;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncLogMessageListener {

  @Async
  @EventListener
  public void execute(final AsyncEventWrapper<Stub> stubEventWrapper) {
    try {
      Thread.sleep(1000L); //To simulate a longer processing
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    out.println(format("Stub ID %s async event was execute", stubEventWrapper.getStub().getId()));
  }

}
