package com.agendapro.product_demo;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductDemoApplication {

	public static void main(String[] args) throws Exception {
		
		ActiveMQServer serverMQ = ActiveMQServers.newActiveMQServer(
				new ConfigurationImpl().setMaxDiskUsage(98).setSecurityEnabled(false).setJournalDirectory("activeMQ/data/journal")
						.setPersistenceEnabled(false).addAcceptorConfiguration("invm", "vm://localhost"));
		serverMQ.start();
		
		SpringApplication.run(ProductDemoApplication.class, args);
	}

}
