package com.uniovi.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.test.pageobjects.prof.PO_RegisterView_Prof;
import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_View;

class ProfessorsTest {

	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "E:\\IISOFT\\TERCERO\\2sem\\Sistemas Distribuidos e Internet\\Practicas\\PL-SDI-Sesión5-material\\geckodriver022win64.exe";

	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	// Antes de cada prueba se navega al URL home de la aplicación
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	@Test
	void Prueba1() {
		//Entramos como admin, que es el que puede modificar los profesores
		PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH());
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		PO_View.checkElement(driver, "text", "Notas del usuario");
		//click en el boton de añadir profesores
		PO_HomeView.clickOption(driver, "addProf", "class", "btn btn-primary");
		PO_RegisterView_Prof.fillForm(driver, "12345678F", "Antonio", "Suarez", "Matematicas");
		
	}
	
	@Test
	void Prueba2() {
		//Entramos como admin, que es el que puede modificar los profesores
		PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH());
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		PO_View.checkElement(driver, "text", "Notas del usuario");
		//click en el boton de añadir profesores
		PO_HomeView.clickOption(driver, "addProf", "class", "btn btn-primary");
		PO_RegisterView_Prof.fillForm(driver, "", "", "", "Matematicas");	
	}
	
	@Test
	void Prueba3() {
		//Entramos como admin, que es el que puede modificar los profesores
		PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH());
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		PO_View.checkElement(driver, "text", "Notas del usuario");
		//click en el boton de añadir profesores
		try {
			PO_HomeView.clickOption(driver, "addProf", "class", "btn btn-primary");
		}catch(Exception e) {
			System.out.println("no esta disponible la opción");
		}
	}
	

}
