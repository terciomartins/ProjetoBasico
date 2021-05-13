package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;
import br.ce.wcaquino.core.BaseTeste;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.HomePage;


public class SaldoTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private HomePage homePage = new HomePage();
	
	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaSaldo();
		String saldo = homePage.obterSaldoConta("Conta com Movimento");
		Assert.assertEquals("500.00", saldo);
	}

}
