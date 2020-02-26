package com.poc.eventlistener.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AsyncEventWrapper<T extends Stub> {

    private T stub;

}
