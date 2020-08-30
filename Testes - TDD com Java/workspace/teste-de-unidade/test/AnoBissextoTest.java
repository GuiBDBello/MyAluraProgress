import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void deveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertEquals(true, anoBissexto.ehBissexto(2016));
		assertEquals(true, anoBissexto.ehBissexto(2012));
		assertEquals(true, anoBissexto.ehBissexto(2000));
	}

	@Test
	public void naoDeveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertEquals(false, anoBissexto.ehBissexto(2015));
		assertEquals(false, anoBissexto.ehBissexto(2011));
	}

}
