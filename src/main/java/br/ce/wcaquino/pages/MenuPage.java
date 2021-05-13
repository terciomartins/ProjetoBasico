package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");		
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");		
	}
	
	public void acessarTelaCriarMovimentacao() {
		clicarLink("Criar Movimentação");		
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink("Resumo Mensal");		
	}

	public void acessarTelaSaldo() {
		clicarLink("Home");		
	}

}
