package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\dev\\seleniumDriver\\chromedriver.exe");
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}	
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descricao
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

		// escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("14/02/2023");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		} finally {
			//fechar o browser
			driver.quit();	
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();

		// escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("14/02/2023");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar o browser
			driver.quit();	
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descricao
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		} finally {
			//fechar o browser
			driver.quit();	
		}
		
	}
	
	
}
