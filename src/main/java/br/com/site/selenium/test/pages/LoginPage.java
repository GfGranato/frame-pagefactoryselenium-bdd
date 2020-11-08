package br.com.site.selenium.test.pages;

import br.com.site.selenium.core.driver.BasePage;
import br.com.site.selenium.core.utils.enums.JSONFileManager;
import br.com.site.selenium.core.utils.report.PrintScreenManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement linkSignIn;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement campoEmail;
    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement campoSenha;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement btnSignIn;

    @FindBy(xpath = "//div[@class = 'alert alert-danger']//li")
    private WebElement msgErroEmail;

    public boolean aguardarPaginaInicialCarregar() {
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
        return super.verificaElementoPresenteTela(linkSignIn);
    }


    public void clicarSignIn() {
        linkSignIn.click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencheEmailLogin(String condicao) throws IOException, ParseException {
        waitForElementPageToBeClickable(campoEmail);
        if (condicao.toLowerCase().equals("invalido")) {
            campoEmail.sendKeys("email@falso.co.jp");
        } else {
            campoEmail.sendKeys(JSONFileManager.readJSONEmail());
        }
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencheSenhaValida() throws IOException, ParseException {
        campoSenha.sendKeys(JSONFileManager.readJSONSenha());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void clicarBtnSignIn() {
        btnSignIn.click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public String getMsgErroEmail() {
        waitForElementToBeVisible(msgErroEmail);
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
        return msgErroEmail.getText();
    }
}
