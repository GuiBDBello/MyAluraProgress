package br.com.alura.teste;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Venda;

public class MapeiaXmlDireto {

	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		
		System.out.println(venda);
	}
	
}
