package br.com.caelum.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
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
		
		Destination fila = (Destination) context.lookup("financeiro");
		
		MessageProducer producer = session.createProducer(fila);

		TextMessage message = session.createTextMessage("<pedido><id>25</id></pedido>");
		producer.send(message);
		
//		for (int i = 0; i < 1000; i++) {
//			TextMessage message = session.createTextMessage("<pedido><id>" + i + "</id></pedido>");
//			producer.send(message);
//		}
		//new Scanner(System.in).nextLine();
		
		session.close();
		connection.close();
		context.close();
		
	}

}
