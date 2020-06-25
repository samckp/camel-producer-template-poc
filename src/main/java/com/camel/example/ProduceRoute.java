package com.camel.example;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

public class ProduceRoute {

    @Produce("direct:simpleRoute")
    ProducerTemplate producerTemplate;


}
