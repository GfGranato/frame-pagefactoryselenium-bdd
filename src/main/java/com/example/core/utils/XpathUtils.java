package com.example.core.utils;

import com.example.core.BasePage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class XpathUtils{

    private BasePage dsl = new BasePage();

    public List<String> retornarListDeStringAPartirDeUmaListaDeElementos(WebElement... webElements){
        List<String> retorno = new ArrayList<>();
        for (WebElement webElement : webElements){
            retorno.add(dsl.recuperarTexto(webElement));
        }
        return retorno;
    }

}
