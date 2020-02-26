package com.poc.eventlistener.listeners;

import static java.lang.String.format;
import static java.lang.System.out;

import com.poc.eventlistener.domain.EventWrapper;
import com.poc.eventlistener.domain.Stub;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogMessageListener {

  @EventListener
  public void execute(final EventWrapper<Stub> stubEventWrapper) {
    out.println(format("Stub ID %s event was execute", stubEventWrapper.getStub().getId()));
  }

}
