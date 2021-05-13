package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTeste;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING) // define q os testes serao executados em ordem alfabetica
public class ContaTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta(){
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Nova");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());		
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarConta("Conta Alterada");
		contasPage.setNome("Conta Alterada 2");
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaMesmoNome(){
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Existente");
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());		
	}
	
	@Test
	public void test3_ExcluirConta(){
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta para Exclusao");		
		Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());		
	}
}
