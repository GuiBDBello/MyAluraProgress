package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class MapeiaXmlDireto {

	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		xmlParaObjeto(jaxbContext);
		
		objetoParaXml(jaxbContext);
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Livro de java", 59.90));
		produtos.add(new Produto("Livro de xml", 59.90));
		produtos.add(new Produto("Livro de O.O", 59.90));
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		
		System.out.println(writer.toString());
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
	
}
