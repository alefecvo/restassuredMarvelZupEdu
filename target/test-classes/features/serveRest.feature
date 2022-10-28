# language: pt
  Funcionalidade: API ServeRest
    @cadastrar-usuario
    Cenário: Cadastrar novo usuário
      Dado que desejo criar uma nova conta válida
      Quando fazer requisição
      Então valido conta criada com sucesso