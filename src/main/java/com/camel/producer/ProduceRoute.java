package com.camel.producer;

import org.apache.camel.*;
import org.springframework.stereotype.Component;

@Component
public class ProduceRoute implements Processor {

    @Produce("direct:simpleRoute")
    ProducerTemplate producerTemplate;

    @Override
    public void process(Exchange exchange) throws Exception {

        exchange.getIn().setBody("This message from Processor !!");
        System.out.println(">>>>>>>>>" +exchange.getIn().getBody());
        producerTemplate.send("direct:simpleRoute",exchange);

    }
}
