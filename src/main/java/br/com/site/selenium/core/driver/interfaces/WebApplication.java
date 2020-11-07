package br.com.site.selenium.core.driver.interfaces;

import org.openqa.selenium.WebDriver;

/**
 * Interface para usar no Enum de recuperação do browser
 *
 * @author Guilherme-Evangelista
 * @author guilherme.granato
 */
public interface WebApplication {
    WebDriver getDriver();
}
