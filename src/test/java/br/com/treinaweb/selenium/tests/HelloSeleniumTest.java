package br.com.treinaweb.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest extends TreinaWebSeleniumTestBase{
	
	@Test
	public void testHelloSelenium() {
		setUrl("file:///home/sys12/Downloads/wGfW75h8-5-casos-de-teste-e-suite-de-teste/teste-selenium.html#");
		getDriver().findElement(By.id("txb-nome")).sendKeys("TreinaWebCursos");
		String textoInput = getDriver().findElement(By.id("txb-nome")).getAttribute("value");
		Assert.assertEquals(textoInput, "TreinaWebCursos");
	}
}
