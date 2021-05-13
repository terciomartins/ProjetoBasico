package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.KillDriver;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcaquino.pages.LoginPage;

public class BaseTeste {
	
	@Rule
	public TestName testName = new TestName();

	private LoginPage page = new LoginPage();
	
	@Before // login: uma opcao e deixar aqui, a outra e deixar no suite geral
	public void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("tercio@martins");
		page.setSenha("123456");
		page.entrar();
	}

	@After // anotacao do junit que indica que ao final de cada teste, este metodo deve ser executado
	public void finaliza() throws IOException {
		
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir"));
		// File.separator cria uma bara de acordo com o sistema operacional em que esta sendo rodado
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot"  + File.separator +  testName.getMethodName()+".jpg")); // ele coloca o arquivo na raiz do projeto - user.dir
		
		
		if(Propriedades.FECHAR_BROWSER) {
			KillDriver();
		}				
	}
}
