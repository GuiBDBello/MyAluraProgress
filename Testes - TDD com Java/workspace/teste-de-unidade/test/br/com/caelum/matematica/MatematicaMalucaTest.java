package br.com.caelum.matematica;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
    public void deveVerificarContaComNumeroAcimaDe30() {
    	MatematicaMaluca matematica = new MatematicaMaluca();
    	int numero = 50;
    	assertEquals(numero * 4, matematica.contaMaluca(numero));
    }
    
	@Test
    public void deveVerificarContaComNumeroAbaixoDe30EAcimaDe10() {
		MatematicaMaluca matematica = new MatematicaMaluca();
    	int numero = 20;
    	assertEquals(numero * 3, matematica.contaMaluca(numero));
    }
	
	@Test
    public void deveVerificarContaComNumeroAbaixoDe10() {
		MatematicaMaluca matematica = new MatematicaMaluca();
    	int numero = 5;
    	assertEquals(numero * 2, matematica.contaMaluca(numero));
    }
}