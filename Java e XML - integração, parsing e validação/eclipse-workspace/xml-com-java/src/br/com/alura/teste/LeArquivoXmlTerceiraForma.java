package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class LeArquivoXmlTerceiraForma {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
		
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<Produto>();
		
		while(eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();
			
			if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = new Produto();
			} else if (evento.isStartElement() && evento.asStartElement().equals("nome")) {
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			} else if (evento.isStartElement() && evento.asStartElement().equals("preco")) {
				evento = eventos.nextEvent();
				double preco = Double.parseDouble(evento.asCharacters().getData());
				produto.setPreco(preco);
			} else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				produtos.add(produto);
			}
		}
		
		System.out.println(produtos);
	}
	
}
