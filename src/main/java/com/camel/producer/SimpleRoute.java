package com.camel.producer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class).log(LoggingLevel.WARN, "Exception in Bean caught here");

        from("direct:simpleRoute")
                .routeId("simpleRoute")
                .log(LoggingLevel.INFO, "body >>>> ${body}")
                .log(LoggingLevel.INFO, "Simple Route executed !!")
                .to("mock:output")
                ;
    }
}
