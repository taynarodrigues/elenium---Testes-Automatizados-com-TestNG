package br.com.treinaweb.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CadastroUsuarioTest  extends TreinaWebSeleniumTestBase{
	
	@BeforeMethod
	public void setupPage() {
		setUrl("file:///home/sys12/Downloads/wGfW75h8-5-casos-de-teste-e-suite-de-teste/teste-selenium.html");
	}
	
//	@Test(priority = 2)
	@Test
	public void verifcarEmailsDiferentesTest() {
		getDriver().findElement(By.id("txb-email")).sendKeys("cleber.campomori@treinaweb.com.br");
		getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("cleber.campomori@gmail.com");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-email")).isDisplayed());
		Assert.assertEquals(getDriver().findElement(By.id("div-val-email")).getText(), "Os e-mails devem ser iguais");	
	}
	
//	@Test(priority = 1)
	@Test
	public void verificarNomeNaoPreenchidoTest() {
		getDriver().findElement(By.id("txb-nome")).sendKeys("");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-nome")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("txb-nome")).getAttribute("class").contains("is-invalid"));
	}
	
//	@Test(priority = 3)
	@Test
	public void verficarusuarioPreenchidoTest() {
		getDriver().findElement(By.id("txb-nome")).sendKeys("Tayna Rodrigues");
		getDriver().findElement(By.id("txb-email")).sendKeys("taynajesus@gmail.com");
		getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("taynajesus@gmail.com");
		getDriver().findElement(By.id("txb-senha")).sendKeys("1234");
		getDriver().findElement(By.id("txb-confirmar-senha")).sendKeys("1234");
		getDriver().findElement(By.id("rad-sexo-feminino")).click();
		new Select(getDriver().findElement(By.id("sel-estado"))).selectByValue("AM");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-sucesso-cadastro-usuario")).isDisplayed());
		Assert.assertEquals(getDriver().findElement(By.xpath("//table[@id='tbl-usuarios']/tbody/tr[1]/td[1]")).getText(),"tayna");
		
	}
}
