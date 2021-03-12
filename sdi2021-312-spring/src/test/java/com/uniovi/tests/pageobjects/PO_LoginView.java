package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView {
	
	static public void fillForm(WebDriver driver, String dnip,  String passwordp) {
		WebElement username = driver.findElement(By.name("username"));
		username.click();
		username.clear();
		username.sendKeys(dnip);
		WebElement pass = driver.findElement(By.name("password"));
		pass.click();
		pass.clear();
		pass.sendKeys(passwordp);
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
	
	static public void logAndCheck(WebDriver driver, String dni, String password, String expected) {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillForm(driver, dni, password);
        PO_View.checkElement(driver, "text", expected);
    }

}
