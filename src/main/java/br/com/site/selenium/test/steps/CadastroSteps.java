package br.com.site.selenium.test.steps;

import br.com.site.selenium.test.pages.CadastroPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;

public class CadastroSteps {
    CadastroPage cadastroPage;

    public CadastroSteps(){
        cadastroPage = new CadastroPage();
    }

    @Quando("preencho o campo Email com um email valido")
    public void preenchoOCampoEmailComUmEmailValido() throws IOException, ParseException {
        cadastroPage.preencheEmailAdress();
    }

    @E("clico em Create an account")
    public void clicoEmCreateAnAccount() {
        cadastroPage.clicaBtnCreateAccount();
    }

    @E("preencho os campos de cadastro corretamente")
    public void preenchoOsCamposDeCadastroCorretamente() {
        cadastroPage.preencherPrimeiroNome();
        cadastroPage.preencherUltimoNome();
        cadastroPage.preencherSenha();
        cadastroPage.selecionarDataDeNascimento();
        cadastroPage.selecionaGenero();

        cadastroPage.PreencheEndereco();
        cadastroPage.preencheCidadeEstado();
        cadastroPage.preencheZipCode();
        cadastroPage.preencheTelefone();
        cadastroPage.preencheEnderecoReferencia();
    }

    @E("clico em Register")
    public void clicoEmRegister() {
        cadastroPage.clicaBtnRegister();
    }

    @Entao("serei redirecionado para a tela de My Account")
    public void meuCadastroSeraCriadoEsperaOTempoAi() {
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", cadastroPage.getMsgWelcome());
    }
}
