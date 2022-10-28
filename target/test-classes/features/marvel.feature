# language: pt
  Funcionalidade: API Marvel - GET /v1/public/comics
    @comics-marvel
    Cenário: Retornar dados dos quadrinhos da marvel - GET /v1/public/comics
      Dado que desejo buscar dados de todos quadrinhos da marvel
      Quando fazer requisição para rota GET Comics
      Então valido retorno dos dados de todos quadrinhos com sucesso