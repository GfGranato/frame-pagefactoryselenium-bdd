package br.com.site.selenium.test.pages;

import br.com.site.selenium.core.driver.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[.='Home' and parent::li[@class='active']]")
    private WebElement btnHomeAtivo;

    public boolean validarTelaHomeAtiva(){
        super.tirarPrint(btnHomeAtivo);
        return super.verificaElementoPresenteTela(btnHomeAtivo);
    }
}
