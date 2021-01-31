package br.com.caelum.jms.log;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteProdutorFila {

	public static void main(String[] args) throws Exception {
		
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination fila = (Destination) context.lookup("LOG");
		MessageProducer producer = session.createProducer(fila);

		TextMessage message = session.createTextMessage("INFO | Apache ActiveMQ 5.12.0 "
				+ "(localhost, ID:GuiDB-65314-1612109733595-0:1) is starting");
		producer.send(message, DeliveryMode.NON_PERSISTENT, 3, 5000);
		
		session.close();
		connection.close();
		context.close();
		
	}

}
