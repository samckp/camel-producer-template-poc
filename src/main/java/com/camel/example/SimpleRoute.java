package com.camel.example;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:simpleRoute")
                .routeId("simpleRoute")
                .log(LoggingLevel.INFO, "${body}")
                .log(LoggingLevel.INFO, "Simple Route executed !!")
                .to("mock:output")
                ;
    }
}
