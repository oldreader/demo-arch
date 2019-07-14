package com.example.demo.integration.command;

import com.example.demo.bus.InternalBus;
import org.springframework.stereotype.Component;

@Component
public class BusWriteGreetingCommandImpl implements WriteGreetingCommand {

    private final InternalBus internalBus;

    public BusWriteGreetingCommandImpl(InternalBus internalBus) {
        this.internalBus = internalBus;
    }

    @Override
    public void request(String request) {
        internalBus.fireName(request);
    }
}
