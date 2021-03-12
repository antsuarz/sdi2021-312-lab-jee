package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {
	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
	
	
	static public void addAndCheckMarks(WebDriver driver, int userOrder, String descriptionp, String scorep, int page) {
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'marks—menu')]/a");
		elementos.get(0).click();
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'mark/add')]");
		elementos.get(0).click();
		fillFormAddMark(driver, userOrder, descriptionp, scorep);
		List<WebElement> e = PO_View.checkElement(driver, "free", "//a[contains(@class, 'page-link')]");
		e.get(page).click();
		e = PO_View.checkElement(driver, "text", descriptionp);
	}
	
	static public void deleteMarkAndCHeck(WebDriver driver, String descriptionp, int page) {
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'marks—menu')]/a");
		elementos.get(0).click();
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'mark/list')]");
		elementos.get(0).click();
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@class, 'page-link')]");
		elementos.get(page).click();
		elementos = PO_View.checkElement(driver, "free", "//td[contains(text(), '" + descriptionp
				+ "')]/following-sibling::*/a[contains(@href, 'mark/delete')]");
		elementos.get(0).click();
		List<WebElement> e = PO_View.checkElement(driver, "free", "//a[contains(@class, 'page-link')]");
		e.get(page).click();
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, descriptionp, PO_View.getTimeout());
	}
}