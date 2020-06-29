package com.camel.producer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class).log(LoggingLevel.WARN, "Exception in Bean caught here");

        from("{{timeRoute}}")
                .routeId("timerRoute")
                .setBody(simple("{{message}}"))
                .process(new ProduceRoute())
                .log(LoggingLevel.INFO, "${body}")
                .to("mock:out");
    }
}
