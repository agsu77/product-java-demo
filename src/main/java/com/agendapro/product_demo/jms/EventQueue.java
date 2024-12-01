package com.agendapro.product_demo.jms;

import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.agendapro.product_demo.solvers.SolverCrearEstadisticas;

import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventQueue {

	
	private final JmsTemplate template;
	private final SolverCrearEstadisticas solver;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private static final String QUEUE_NAME = "creacion-producto-queue";
	
	public void sendMessage() {
		logger.info("Enviando evento de creacion de producto...");
		try {
			template.convertAndSend(QUEUE_NAME, "producto-creado");
		} catch (Exception e) {
			logger.severe("Error al enviar evento... "+e);
			throw e;
		}finally {
			logger.info("Finaliza envio de evento.");			
		}
	}
	
	@JmsListener(destination = QUEUE_NAME)
	public void listenMessage(@Payload String messageString, Message message) {
		logger.info("Recivo un evento de creacion de producto y mando a crear estadisticas.");
		try {
			// Mando a crear las estadisticas.
			solver.solve();			
		} catch (Exception e) {
			logger.severe("Error al crear las estadisticas."+ e);
			throw e;
		}finally {
			logger.info("Finalizo el procesamiento de estadisticas.");
		}
	}
}
