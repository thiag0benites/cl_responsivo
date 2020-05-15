$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ECCM-46.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    },
    {
      "line": 2,
      "value": "#Author: Thiago Benites"
    }
  ],
  "line": 4,
  "name": "ECCM-46",
  "description": "EU como GC QUERO que os beneficios do plano sejam alterados no front de acordo com as condições de compra selecionadas pelo usuário \r\nPARA que sejam apresentados os benefícios corretos por seleção do usuário \r\nE aumentar a conversão e ticket médio de compras da Loja Online CRITÉRIOS",
  "id": "eccm-46",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 3,
      "name": "@ECCM-46"
    },
    {
      "line": 3,
      "name": "@US39015"
    }
  ]
});
formatter.before({
  "duration": 17305043400,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "CT03 Alterações no Plano PLP Controle_Mobile",
  "description": "",
  "id": "eccm-46;ct03-alterações-no-plano-plp-controle-mobile",
  "type": "scenario",
  "keyword": "Cenario",
  "tags": [
    {
      "line": 9,
      "name": "@ECCM-46-CT03"
    },
    {
      "line": 9,
      "name": "@US39015-CT03"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "que ao acessar o site do ecommerce",
  "keyword": "Dado "
});
formatter.step({
  "line": 12,
  "name": "selecionar a regionalizacao estado \"SP\" e cidade \"SÃO PAULO\"",
  "keyword": "E "
});
formatter.match({
  "location": "ContextoSteps.queAoAcessarOSiteDoEcommerce()"
});
formatter.write("Acesso realizado com sucesso");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 9360642400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SP",
      "offset": 36
    },
    {
      "val": "SÃO PAULO",
      "offset": 50
    }
  ],
  "location": "HomeSteps.selecionarARegionalizacaoEstadoECidade(String,String)"
});
formatter.write("Localização selecionada com sucesso");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 10219024600,
  "status": "passed"
});
formatter.after({
  "duration": 285334700,
  "status": "passed"
});
});