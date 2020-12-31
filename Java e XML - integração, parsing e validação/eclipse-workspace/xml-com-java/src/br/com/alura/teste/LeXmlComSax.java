package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handlers.ProdutosHandler;

public class LeXmlComSax {

	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		InputStream inputStream = new FileInputStream("src/vendas.xml");
		InputSource inputSource = new InputSource(inputStream);
		leitor.parse(inputSource);
		
		System.out.println(logica.getProdutos());
	}
	
}
