package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTeste;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTeste{
	
	private MenuPage menuPage = new MenuPage();
	
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		
		movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date())); // insere uma data atual
		movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("teste 123");
		movimentacaoPage.setInteressado("eu mesmo");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("conta","Conta com Movimento2");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());		
	}
	
	@Test
	public void test2_CamposObrigatorios() {		
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		// Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio")); // boa, mas nao e ideal
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero")));	
		Assert.assertEquals(6,erros.size());
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("teste 123");
		movimentacaoPage.setInteressado("eu mesmo");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("conta", "Conta com Movimento");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();	
		
		List<String> erros = movimentacaoPage.obterErros();
		// Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio")); // boa, mas nao e ideal
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));	
		Assert.assertEquals(1,erros.size());
	}

}
