#language: pt
#encoding: utf-8

@cadastro @regressivo
Funcionalidade: Cadastro
  Como um futuro usuario do site
  Gostaria de criar um novo usuario para acessar o site

  Contexto: Acessar tela de cadastro
    Dado que eu acesso o site
    E clico em Sign in

  @executar @web
  Cenario: Realizar cadastro com sucesso no sistema
    Quando preencho o campo Email com um email valido
    E clico em Create an account
    E preencho os campos de cadastro corretamente
    E clico em Register
    Entao serei redirecionado para a tela de My Account