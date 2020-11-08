package br.com.site.selenium.test.steps;

import br.com.site.selenium.test.pages.LoginPage;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;

public class LoginSteps {

    protected LoginPage loginPage = new LoginPage();

    @Dado("que eu acesso o site")
    public void queEuAcessoOSite() {
        Assert.assertTrue(loginPage.aguardarPaginaInicialCarregar());
    }

    @E("clico em Sign in")
    public void clicoEmSignIn() {
        loginPage.clicarSignIn();
    }

    @Quando("realizo login com o usuario {string}")
    public void realizoLoginComOUsuario(String condicao) throws IOException, ParseException {
        loginPage.preencheEmailLogin(condicao);
        loginPage.preencheSenhaValida();
    }

    @E("Clico no botao Sign In")
    public void clicoNoBotaoSignIn() {
        loginPage.clicarBtnSignIn();
    }

    @Entao("valido que nao foi possivel realizar o login")
    public void validoQueNaoFoiPossivelRealizarOLogin() {
        Assert.assertEquals("Authentication failed.", loginPage.getMsgErroEmail());
    }
}
