package com.poc.eventlistener.publishers;

import com.poc.eventlistener.domain.AsyncEventWrapper;
import com.poc.eventlistener.domain.EventWrapper;
import com.poc.eventlistener.domain.StubA;
import com.poc.eventlistener.domain.StubB;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogMessagePublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  @EventListener(ApplicationReadyEvent.class)
  public void publishAnAsyncEvent() {
    System.out.println("Start async execution");
    final AsyncEventWrapper<StubA> stubA = AsyncEventWrapper.<StubA>builder().stub(new StubA()).build();
    final AsyncEventWrapper<StubB> stubB = AsyncEventWrapper.<StubB>builder().stub(new StubB()).build();

    applicationEventPublisher.publishEvent(stubA);
    applicationEventPublisher.publishEvent(stubB);

    System.out.println("End async execution");
  }

  @EventListener(ApplicationReadyEvent.class)
  public void publishAnSyncEvent() {

    System.out.println("Start sync execution");
    final EventWrapper<StubA> stubA = EventWrapper.<StubA>builder().stub(new StubA()).build();
    final EventWrapper<StubB> stubB = EventWrapper.<StubB>builder().stub(new StubB()).build();

    applicationEventPublisher.publishEvent(stubA);
    applicationEventPublisher.publishEvent(stubB);

    System.out.println("End sync execution");
  }

}
