package com.camel.producer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{timeRoute}}")
                .routeId("timerRoute")
                .setBody(simple("{{message}}"))
                .process(new ProduceRoute())
                .log(LoggingLevel.INFO, "${body}")
                .to("mock:out");
    }
}
