package principal.util;

public interface Mensagem {

    //CRUD
    final static String CREATE = "CADASTRAR ";
    final static String READ = "LISTAR";
    final static String UPDATE = "ALTERAR";
    final static String DELETE = "DELETAR";

	//MENUS
    final static String MENU_PRINCIPAL = "               MENU PRINCIPAL";
    final static String OPCAO_INVALIDA = "OPÇÃO INVALIDA, TENTE NOVAMENTE";
    final static String MSG_ESCOLHA_UMA_OPÇÃO = "ESCOLHA UMA DAS OPÇÕES";
    final static String FINALIZADO = "PROGRAMA FINALIZADO";
    final static String EXCLUIR = "EXCLUIR";
    final static String VOLTAR = "VOLTAR";
    final static String SIM = "SIM";
    final static String FINALIZAR_PROGRAMA = "FINALIZAR PROGRAMA";

    //LOGIN
    final static String TELA_LOGIN = "                   TELA DE LOGIN";
    final static String MSG_INFORME_LOGIN = "INFORME O LOGIN: ";
    final static String MSG_INFORME_SENHA = "INFORME A SENHA: ";
    final static String MSG_LOGIN_OR_SENHA_INVALID = "LOGIN OU SENHA INVALIDO, TENTE NOVAMENTE!";

    //CADASTROS
    final static String TELA_DE_CADASTROS = "TELA DE CADASTROS";
    
    //PESSOA
    final static String INFORME_NOME = "NOME:";
    final static String INFORME_CPF = "INFORME O CPF: Ex:00000000000";
    final static String INFORME_TELEFONE = "TELEFONE:";
    final static String INFORME_EMAIL = "EMAIL:";
    final static String INFORME_SEXO = "SEXO:";

    //CLIENTE
    final static String MSG_CADASTRO_CLIENTE = "CADASTRO DE CLIENTES"; 
    final static String MENU_CLIENTE = "MENU CLIENTE";
    final static String INFORME_ENDERECO = "ENDEREÇO: ";
    final static String REFAZER = "DESEJA REFAZER A OPERAÇÃO? ";
    final static String LISTA_DE_CLIENTES = "LISTA DE CLIENTES";
    final static String NAO_HA_CLIENTES = "NAÕ EXISTEM CLIENTES CADASTRADOS";
    final static String UPDATE_CLIENTE = "ALTERAR CLIENTE";
    final static String CPF_ORIGINAL = "INFORME O CPF DO CLIENTE QUE DESEJA ALTERAR: ";
    final static String CPF_DELETE = "INFORME O CPF DO CLIENTE QUE DESEJA DELETAR: ";
    final static String NOVOS_DADOS = "INSIRA OS NOVOS DADOS DESTE CLIENTE";
    final static String ALTERADO_COM_SUCESSO = "CLIENTE ALTERADO COM SUCESSO";
    final static String CLIENTE_NAO_ENCONTRADO = "CLIENTE NÃO FOI ENCONTRADO";
    final static String DELETAR_CLIENTE = "DELETAR CLIENTE";
    final static String EXCLUIDO_COM_SUCESSO = "CLIENTE EXCLUIDO COM SUCESSO";
    final static String CLIENTE_CAD_SUCESSO = "CLIENTE CADASTRADO COM SUCESSO!";
    final static String JA_EXISTE = "JÁ EXISTE UM CLIENTE CADASTRADO COM ESSE CPF";

    //FUNCIONARIO 
    final static String MENU_FUNCIONARIO = "MENU FUNCIONÁRIO";
    final static String MSG_CADASTRO_FUNCIONARIO = "CADASTRO DE FUNCIONÁRIOS";
    final static String INFORME_DATA = "INFORME A DATA DE ADMISSÃO DESTE FUNCIONÁRIO Ex(AAAA-MM-DD)";
    final static String INFORME_HORA_ENTRADA = "INFORME A HORA DA ENTRADA DESTE FUNCIONÁRIO Ex(HH:mm:ss)";
    final static String INFORME_HORA_SAIDA = "INFORME A HORA DA SAÍDA DESTE FUNCIONÁRIO Ex(HH:mm:ss)";
    final static String NOVO_FUNCIONARIO = "DESEJA CADASTRAR UM NOVO FUNCIONÁRIO? ";
    final static String LISTA_DE_FUNCIONARIOS = "LISTA DE FUNCIONÁRIOS";
    final static String NAO_HA_FUNCIONARIOS = "NÃO EXISTEM FUNCIONÁRIOS CADASTRADOS";
    final static String UPDATE_FUNCIONARIO = "ALTERAR FUNCIONÁRIO";
    final static String NOVOS_DADOS_FUNCIONARIO = "INSIRA OS NOVOS DADOS DESTE FUNCIONÁRIO";
    final static String ALTERADO_FUNCIONARIO_SUCESSO = "FUNCIONÁRIO ALTERADO COM SUCESSO";
    final static String CPF_ORIGINAL_FUNCIONARIO = "INFORME O CPF DO FUNCIONÁRIO QUE DESEJA ALTERAR: ";
    final static String NOME_ORIGINAL_FUNCIONARIO = "INFORME O NOME DO FUNCIONÁRIO QUE DESEJA ALTERAR: ";
    final static String EXCLUIR_FUNCIONARIO = "EXCLUIR FUNCIONÁRIO";
    final static String NOME_EXCLUIR_FUNCIONARIO = "INFORME O NOME DO FUNCIONÁRIO QUE DESEJA EXCLUIR: ";
    final static String EXCLUIDO_FUNCIONARIO_COM_SUCESSO = "FUNCIONÁRIO EXCLUIDO COM SUCESSO";
    final static String FUNCIONARIO_NAO_ENCONTRADO = "O FUNCIONÁRIO NÃO FOI ENCONTRADO";
    final static String FUNCIONARIO_EXISTE = "UM FUNCIONÁRIO COM ESTE CPF JÁ EXISTE EM NOSSO SISTEMA";
    final static String FUNCIONARIO_CPF_DELETE = "INFORME O CPF DO FUNCIONÁRIO QUE DESEJA DELETAR";
    final static String FUNCIONARIO_EXCLUIDO = "FUNCIONÁRIO EXCLUÍDO COM SUCESSO";
    final static String DELETAR_FUNCIONARIO = "DELETAR FUNCIONÁRIO";
    final static String FUNC_CAD_SUCESSO = "FUNCIONARIO CADASTRADO COM SUCESSO";

    //PRODUTO
    final static String MSG_CADASTRO_PRODUTO = "CADASTRO DE PRODUTOS";
    final static String MENU_PRODUTO = "MENU PRODUTOS";
    final static String LISTA_DE_PRODUTOS = "LISTA DE PRODUTOS";
    final static String NOVO_PRODUTO = "DESEJA CADASTRAR UM NOVO PRODUTO?";
    final static String INFORME_NOME_PRODUTO = "NOME DO PRODUTO:";
    final static String INFORME_MARCA = "MARCA:";
    final static String INFORME_PRECO = "PREÇO:  Ex(4.99)";
    final static String INFORME_CODBARRA = "CÓDIGO DE BARRAS:";
    final static String NAO_HA_PRODUTOS = "NÃO EXISTEM PRODUTOS CADASTRADOS";
    final static String UPDATE_PRODUTO = "ALTERAR PRODUTO";
    final static String ID_ORIGINAL_PRODUTO = "INFORME O ID DO PRODUTO QUE DESEJA ALTERAR: ";
    final static String NOME_EXCLUIR_PRODUTO = "INFORME O NOME DO PRODUTO QUE DESEJA EXCLUIR: ";
    final static String NOVOS_DADOS_PRODUTO = "INSIRA OS NOVOS DADOS DESTE PRODUTO";
    final static String PRODUTO_ALTERADO_COM_SUCESSO = "PRODUTO ALTERADO COM SUCESSO";
    final static String INFORME_ID = "INFORME O ID DO PRODUTO: ";
    final static String ID_JA_EXISTE = "ID JÁ EXISTE";
    final static String MSG_EXCLUSAO_PRODUTO = "EXCLUSÃO DE PRODUTOS";
    final static String DELETAR_OUTRO_PRODUTO = "DESEJA DELETAR OUTRO PRODUTO?";
    final static String PRODUTO_EXCLUIDO_SUCESSO = "PRODUTO EXCLUÍDO COM SUCESSO";
    final static String PRODUTO_NAO_ENCONTRADO = "PRODUTO NÃO ENCONTRADO";
    
    //ESTOQUE
    final static String MENU_ESTOQUE = "MENU ESTOQUE";
    final static String MSG_CADASTRO_ESTOQUE = "CADASTRO DE ESTOQUE";
    final static String INFORME_PRODUTO = "INFORME O PRODUTO: ";
    final static String INFORME_QUANTIDADE = "INFORME A QUANTIDADE: ";
    final static String INFORME_ENDERECO_ESTOQUE = "INFORME O ENDEREÇO: ";
    final static String LISTA_ESTOQUE = "LISTA DO ESTOQUE";
    final static String ESTOQUE_VAZIO = "ESTOQUE VAZIO";
    final static String ID_INVALIDA = "ID INVÁLIDA";
    final static String UPDATE_ESTOQUE = "ATUALIZAR ESTOQUE";
    final static String QTDE_ESTOQUE = "QUANTIDADE EM ESTOQUE";
    final static String NOVA_QTDE = "INSIRA QUANTIDADE DO PRODUTO NO ESTOQUE";
    final static String ESTOQUE_ALTERADO = "ESTOQUE ALTERADO COM SUCESSO";
    final static String EXCLUIR_ESTOQUE = "EXCLUIR PRODUTO DO ESTOQUE";
    final static String INFORME_ID_EXCLUIR_ESTOQUE = "INFORME O ID DO PRODUTO QUE DESEJA EXCLUIR DO ESTOQUE: ";
    final static String ESTOQUE_EXCLUIDO = "PRODUTO EXCLUIDO DO ESTOQUE COM SUCESSO";
    final static String PRODUTO_CADASTRADO_ESTOQUE = "PRODUTO CADASTRADO NO ESTOQUE";
    final static String PRODUTO_EXISTENTE_ESTOQUE = "NÃO É POSSÍVEL CADASTRAR UM PRODUTO JA EXISTENTE";
    final static String INFORME_ID_CADASTRO = "INFORME O ID DO PRODUTO QUE DESEJA CADASTRAR";
    final static String INFORME_ID_ALTERAR = "INFORME O ID DO PRODUTO QUE DESEJA ALTERAR";
    final static String CADASTRAR_OUTRO = "DESEJA CADASTRAR OUTRO PRODUTO?";
    final static String ALTERAR_OUTRO = "DESEJA ATUALIZAR OUTRO PRODUTO?";
    final static String DELETAR_OUTRO = "DESEJA DELETAR OUTRO PRODUTO?";
    final static String ESTOQUE_ATUAL = "ESTOQUE ATUAL";

    //GERENTE
    final static String MENU_GERENTE = "MENU GERENTE";
    final static String MSG_CADASTRO_GERENTE = "CADASTRO DE GERENTES"; 
    final static String LISTA_DE_GERENTES = "LISTA DE GERENTES";
    final static String NAO_HA_GERENTES = "NAÕ EXISTEM GERENTES CADASTRADOS";
    final static String UPDATE_GERENTE = "ALTERAR GERENTE";
    final static String NOME_ORIGINAL_GERENTE = "INFORME O NOME DO GERENTE QUE DESEJA ALTERAR: ";
    final static String CPF_DELETE_GERENTE = "INFORME O CPF DO GERENTE QUE DESEJA DELETAR: ";
    final static String NOVOS_DADOS_GERENTE = "INSIRA OS NOVOS DADOS DESTE GERENTE";
    final static String ALTERADO_COM_SUCESSO_GERENTE = "GERENTE ALTERADO COM SUCESSO";
    final static String GERENTE_NAO_ENCONTRADO = "GERENTE NÃO FOI ENCONTRADO";
    final static String DELETAR_GERENTE = "DELETAR GERENTE";
    final static String EXCLUIDO_COM_SUCESSO_GERENTE = "GERENTE EXCLUIDO COM SUCESSO";
    final static String JA_EXISTE_GERENTE = "JÁ EXISTE UM GERENTE CADASTRADO COM ESSE CPF";
    final static String INFORME_DATA_ADMISSAO = "INFORME A DATA DE ADMISSÃO DO GERENTE Ex: AAAA-MM-DD";
    final static String INFORME_SALARIO = "INFORME O SALÁRIO DO GERENTE Ex: 2000.0"; 
    
    

}
