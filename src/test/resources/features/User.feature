#language: pt
# Author: Carlos Moreira
# Date: 14/07/2023

@all
Funcionalidade: User

  @cadastrar
  Cenario: Criar usuário
    Dado que realizo um cadastro de usuário
    Então valido o retorno da api com status code "201"
    E valido a criação do usuário
    E valido a estrutura do retorno da api create user
