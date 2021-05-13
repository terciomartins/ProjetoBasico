package br.ce.wcaquino.suites;

import static br.ce.wcaquino.core.DriverFactory.KillDriver;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.tests.ContaTest;
import br.ce.wcaquino.tests.MovimentacaoTest;
import br.ce.wcaquino.tests.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.tests.ResumoTest;
import br.ce.wcaquino.tests.SaldoTest;
import br.ce.wcaquino.utils.DataUtils;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	private static MenuPage menuPage = new MenuPage();
	private static ContasPage contasPage = new ContasPage();
	private static MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	// com thread nao e preciso se preocupar em abrir e fechar driver
	//@BeforeClass // login: uma opcao e deixar aqui, a outra e deixar no baseteste
	//public static void inicializa() {
	//	page.acessarTelaInicial();
	//	page.setEmail("tercio@martins");
	//	page.setSenha("123456");
	//	page.entrar();
	//}
	
	// @AfterClass // somente se a propriedades estiver setando FECHAR_BROWSER = false
	//public static void finaliza() { 
	//	KillDriver();		
	//}

	
	// resetando e gerando massa de dados
	@BeforeClass
	public static void massaDados() {
		//resetando
		page.acessarTelaInicial();
		page.setEmail("tercio@martins");
		page.setSenha("123456");
		page.entrar();
		
		page.resetar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Alterada");
		contasPage.salvar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta com Movimento");
		contasPage.salvar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta com Movimento2");
		contasPage.salvar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Existente");
		contasPage.salvar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta para Exclusao");
		contasPage.salvar();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta para Exclusao de Movimento");
		contasPage.salvar();
		
		menuPage.acessarTelaCriarMovimentacao();
		
		movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date())); // insere uma data atual
		movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("teste 123");
		movimentacaoPage.setInteressado("eu mesmo");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("conta","Conta com Movimento");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		
		movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date())); // insere uma data atual
		movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("teste 123");
		movimentacaoPage.setInteressado("eu mesmo");
		movimentacaoPage.setValor("50");
		movimentacaoPage.setConta("conta","Conta para Exclusao de Movimento");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		
		KillDriver();
	}
}
