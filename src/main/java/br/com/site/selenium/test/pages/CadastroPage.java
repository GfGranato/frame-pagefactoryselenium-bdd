package br.com.site.selenium.test.pages;

import br.com.site.selenium.core.driver.BasePage;

import br.com.site.selenium.core.utils.FakeUtils;
import br.com.site.selenium.core.utils.report.PrintScreenManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CadastroPage extends BasePage {

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement campoEmailAdress;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    protected WebElement btnCreateAccount;
    @FindBy(xpath = "//input[@name='customer_firstname']")
    private WebElement campoFirstName;
    @FindBy(xpath = "//input[@name='customer_lastname']")
    private WebElement campoLastName;
    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement campoPassword;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement boxMes;
    @FindBy(xpath = "//select[@id='months']/option")
    private List<WebElement> optionMes;
    @FindBy(xpath = "//select[@id='days']")
    private WebElement boxDia;
    @FindBy(xpath = "//select[@id='days']/option")
    private List<WebElement> optionDia;
    @FindBy(xpath = "//select[@id='years']")
    private WebElement boxAno;
    @FindBy(xpath = "//select[@id='years']/option")
    private List<WebElement> optionAno;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement campoAdress;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement campoCity;
    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement campoState;
    @FindBy(xpath = "//select[@id='id_state']/option")
    List<WebElement> optionState;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement campoZipCode;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement campoPhone;
    @FindBy(xpath = "//input[@id='alias']")
    private WebElement campoEnderecoReferencia;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement btnRegister;

    @FindBy(xpath = "//input[@name='id_gender']")
    protected List<WebElement> boxGender;

    @FindBy(xpath="//p[@class='info-account']")
    protected WebElement msgWelcome;

    public CadastroPage() {
    }

    public void preencherPrimeiroNome(){
        super.waitForElementPageToBeClickable(campoFirstName);
        super.digitarTexto(campoFirstName, FakeUtils.gerarPrimeiroNome());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }
    public void preencheEmailAdress() {
        super.waitForElementPageToBeClickable(campoEmailAdress);
        String email = FakeUtils.gerarEmail();
        campoEmailAdress.sendKeys(email);
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }
    public void clicaBtnCreateAccount(){
        btnCreateAccount.click();
    }

    public void selecionaGenero() {
        Random random = new Random();
        boxGender.get(random.nextInt(2)).click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencherUltimoNome(){
        super.digitarTexto(campoLastName, FakeUtils.gerarUltimoNome());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencherSenha() {
        campoPassword.sendKeys("senha123");
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void selecionarDataDeNascimento() {
        Random random = new Random();
        boxMes.click();
        optionMes.get(random.nextInt(optionMes.size())).click();
        boxDia.click();
        optionDia.get(random.nextInt(optionDia.size()-3 ) +3).click();
        boxAno.click();
        optionAno.get(random.nextInt(optionAno.size()-30)).click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void PreencheEndereco() {
        campoAdress.sendKeys("Rua "+ FakeUtils.gerarPokemon());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencheCidadeEstado() {
        Random random = new Random();
        campoCity.sendKeys(FakeUtils.gerarNomeRua());
        campoState.click();
        optionState.get(random.nextInt(optionState.size())).click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencheZipCode() {
        campoZipCode.sendKeys("12345");
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void preencheTelefone() {
        campoPhone.sendKeys(FakeUtils.gerarNumeroCelular());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }


    public void preencheEnderecoReferencia() {
        campoEnderecoReferencia.clear();
        campoEnderecoReferencia.sendKeys(FakeUtils.gerarNomeRua());
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public void clicaBtnRegister() {
        btnRegister.click();
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
    }

    public String getMsgWelcome() {
        waitForElementToBeVisible(msgWelcome);
        super.tirarPrint();
        PrintScreenManager.takePrintSave();
        return msgWelcome.getText();
    }
}
