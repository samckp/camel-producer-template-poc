package com.camel.example;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class TimerRoute extends RouteBuilder {

    @Produce("direct:simpleRoute")
    ProducerTemplate producerTemplate;

    @Override
    public void configure() throws Exception {

        from("{{timeRoute}}")
                .routeId("timerRoute")
                .setBody(simple("this is test msg ! ------{{message}}"))
                .log(LoggingLevel.INFO, "${body}")

                .to("mock:out");
    }
}
