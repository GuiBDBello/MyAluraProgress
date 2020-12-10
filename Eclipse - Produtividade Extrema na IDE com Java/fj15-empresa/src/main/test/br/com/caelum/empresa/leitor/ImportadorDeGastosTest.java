package br.com.caelum.empresa.leitor;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;

import br.com.caelum.empresa.modelo.Gasto;

public class ImportadorDeGastosTest {

	@Test
	public void deveRetornarUmaListaVaziaSeOArquivoPassadoForVazio() throws ParseException {
		ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);
		
		assertTrue("A lista não está vazia!", gastos.isEmpty()); 
	}
	
	@Test
	public void deveRetornarUmGastoDeUmArquivoNoFormatoCorreto() throws ParseException {
		String conteudo = "CARTAO01012011000010000123Jose da Silva                 22071983";
		ByteArrayInputStream input = new ByteArrayInputStream(conteudo.getBytes());
		
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);
		
		assertEquals("Deveria conter um elemento!", 1, gastos.size());
	}

}
