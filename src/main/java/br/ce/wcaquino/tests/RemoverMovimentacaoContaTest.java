package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTeste;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta com Movimento");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());		
	}
	
}
