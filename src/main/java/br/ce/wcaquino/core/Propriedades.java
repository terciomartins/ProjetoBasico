package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true; // true fecha o browser em cada teste. false, mantem o browser aberto

	public static Browsers BROWSER = Browsers.IE;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime(); // nanotime cria um numero compsto segundos desde 1970
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		IE,
		EDGE
	}
	
	public enum TipoExecucao{
		LOCAL,
		GRID,
		NUVEM
	}
}
