#language: pt
#Author: Thiago Benites
@ECCM-46 @US39015
Funcionalidade: ECCM-46
  EU como GC QUERO que os beneficios do plano sejam alterados no front de acordo com as condições de compra selecionadas pelo usuário 
  PARA que sejam apresentados os benefícios corretos por seleção do usuário 
  E aumentar a conversão e ticket médio de compras da Loja Online CRITÉRIOS

  @ECCM-46-CT03 @US39015-CT03
  Cenario: CT03 Alterações no Plano PLP Controle_Mobile
    Dado que ao acessar o site do ecommerce
    E selecionar a regionalizacao estado "SP" e cidade "SÃO PAULO"
    #E clicar em Mais detalhes no plano "4GB", "CONTROLE", "64,99"
    #Quando seleciona a fidelizacao "12 meses"
    #Entao validar as promoções e aplicativos
    #Quando seleciona a fidelizacao "Sem fidelização"
    #Entao Validar que as promoções e aplicativos foram alterados

  @ECCM-46-CT04 @US39015-CT04
  Cenario: CT02 Alterações no Plano PLP Pós_Mobile
    Dado que ao acessar o site do ecommerce
    E selecionar a regionalizacao estado "SP" e cidade "SÃO PAULO"
    E clicar em Mais detalhes no plano "15GB", "PÓS-PAGO", "179,99"
    Quando seleciona a fidelizacao "12 meses"
    Entao validar as promoções e aplicativos
    Quando seleciona a fidelizacao "Sem fidelização"
    Entao Validar que as promoções e aplicativos foram alterados
