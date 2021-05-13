package br.ce.wcaquino.tests;

import static br.ce.wcaquino.core.DriverFactory.getDriver;// crtl + shift + m

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTeste;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)  // define q os testes serao executados em ordem alfabetica
public class ResumoTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.clicarExcluirMovimento("Conta para Exclusao de Movimento");
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());		
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle()); // pega o valor do titulo no browser
	}
	
	@Test(expected = NoSuchElementException.class) // Opcao 1 - usado para teste onde um elemento nao e encontrado - ex: tabela vazia
	public void test3_TabelaVazia() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.selecionarCombo("2016");
		resumoPage.buscar();
		DriverFactory.getDriver().findElement(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
	}
	
	@Test // Opcao 2 - usado para teste onde um elemento nao e encontrado - ex: tabela vazia (esse e bom)
	public void test4_TabelaVazia2() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.selecionarCombo("2016");
		resumoPage.buscar();
		try{
			DriverFactory.getDriver().findElement(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
			Assert.fail(); // o teste valido seria dar excption (tabela vazia), mas caso encontre linas na tabela, o teste é forcada a apresentar erro, pois a tabela deveria estar vazia
		}catch(NoSuchElementException e){ // NoSuchElementException e do Selenium
			
		}		
	}
	
	@Test // Opcao 3 - usado para teste onde um elemento nao e encontrado - ex: tabela vazia (esse e o melhor)
	public void test5_TabelaVazia3() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.selecionarCombo("2016");
		resumoPage.buscar();
		//List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
		//Assert.assertEquals(0, elementosEncontrados.size());
		Assert.assertEquals(0, resumoPage.verificarExtratoVazio());
	}
	
	@Test 
	public void test6_TabelaVazia2() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.selecionarCombo("2016");
		resumoPage.buscar();
		Assert.assertEquals(0, resumoPage.verificarExtratoVazio());
	}

}
