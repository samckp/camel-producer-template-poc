package com.camel.producer;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class TimerRouteTests extends CamelTestSupport {

	@Produce("{{timeRoute}}")
	private ProducerTemplate producer;

	@EndpointInject("mock:out")
	MockEndpoint mock;

	@Test
	@DirtiesContext
	public void testRoute() throws InterruptedException {

		String input="test message";
		mock.expectedBodiesReceived(input);

		producer.sendBody("{{timeRoute}}");
		mock.assertIsSatisfied();
	}
}
