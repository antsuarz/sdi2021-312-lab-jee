package com.uniovi.test.pageobjects.prof;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uniovi.tests.pageobjects.PO_NavView;

public class PO_RegisterView_Prof extends PO_NavView{

	static public void fillForm(WebDriver driver, String dnip, String namep, String lastnamep, String asignatura) {
		WebElement dni = driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);
		WebElement name = driver.findElement(By.name("name"));
		name.click();
		name.clear();
		name.sendKeys(namep);
		WebElement lastname = driver.findElement(By.name("surname"));
		lastname.click();
		lastname.clear();
		lastname.sendKeys(lastnamep);
		WebElement asig = driver.findElement(By.name("course"));
		asig.click();
		asig.clear();
		asig.sendKeys(asignatura);
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
