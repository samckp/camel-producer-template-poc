package com.camel.producer;

import org.apache.camel.*;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
class SimpleRouteTests extends CamelTestSupport {

	@Produce("direct:simpleRoute")
	private ProducerTemplate producer;

	@EndpointInject("mock:output")
	MockEndpoint mock;

	@Test
	@DirtiesContext
	public void testRoute() throws InterruptedException {

		String input="test message";
		mock.expectedBodiesReceived(input);

		producer.sendBody("direct:simpleRoute",input );
		mock.assertIsSatisfied();
	}
}
