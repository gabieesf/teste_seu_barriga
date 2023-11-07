#language: pt
@criar_movimentcao
Funcionalidade: Criar Movimentacao
  Cenario: Criar movimentação com sucesso
    Dado que o usuario esteja logado
    E que o usuario que possua uma conta cadastrada
    Quando o usuario clicar na aba Criar Movimentacao
    E o usuario preencher o Tipo da Movimentacao com "Despesa"
    E o usuario preencher a Data da Movimentacao com "17/07/2023"
    E o usuario preencher a Data do Pagamento com "17/07/2023"
    E o usuario preencher a Descricao com "Pagamento de aluguel"
    E o usuario preencher o Interessado com "João"
    E o usuario preencher o valor com "500"
    E o usuario escolher a conta "C6 bank"
    E o usuario alterar a situação para "Pago"
    E o usuario clicar no botao salvar
    Entao o sistema deve apresentar uma mensagem de "Movimentação adicionada com sucesso!"

  Cenario: Criar movimentação com todos os campos em branco
    Dado que o usuario esteja logado
    E que o usuario que possua uma conta cadastrada
    Quando o usuario clicar na aba Criar Movimentacao
    E o usuario preencher o Tipo da Movimentacao com "Receita"
    E o usuario preencher a Data da Movimentacao com ""
    E o usuario preencher a Data do Pagamento com ""
    E o usuario preencher a Descricao com ""
    E o usuario preencher o Interessado com ""
    E o usuario preencher o valor com ""
    E o usuario escolher a conta "C6 bank"
    E o usuario alterar a situação para "Pendente"
    E o usuario clicar no botao salvar
    Entao o sistema deve apresentar uma mensagem de erro com "Data da Movimentação é obrigatório"
    E o sistema deve apresentar uma mensagem de erro com "Data do pagamento é obrigatório"
    E o sistema deve apresentar uma mensagem de erro com "Descrição é obrigatório"
    E o sistema deve apresentar uma mensagem de erro com "Interessado é obrigatório"
    E o sistema deve apresentar uma mensagem de erro com "Valor é obrigatório"
    E o sistema deve apresentar uma mensagem de erro com "Valor deve ser um número"