#language: pt
#encoding: utf-8

@login @regressivo
Funcionalidade: Login
    Como usuario do site
    Gostaria de acessar o site para realizar compras

  Contexto: Acessar o site
    Dado que eu acesso o site
    E clico em Sign in

  @executar @positivo @web
  Cenario: Realizar login com sucesso no sistema
    Quando realizo login com o usuario "cadastrado"
    E Clico no botao Sign In
    Entao serei redirecionado para a tela de My Account

  @executar @negativo @web
  Cenario: Não realizar login ao passar email invalido
    Quando realizo login com o usuario "invalido"
    E Clico no botao Sign In
    Entao valido que nao foi possivel realizar o login

