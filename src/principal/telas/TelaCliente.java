package principal.telas;

import principal.controles.ControleCliente;
import principal.db.Banco;
import principal.modelos.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;

/*
 * @author Lucas Cardoso
 * @version 1.0 Abr 2023
 */

public class TelaCliente {
	
	public static void mostrar(){
	Prompt.linhaEmBranco();
	Prompt.separador();
	Prompt.imprimir(Mensagem.MENU_CLIENTE);
	Prompt.separador();
	Prompt.linhaEmBranco();
	Prompt.imprimir("[1] - " + Mensagem.CREATE);
	Prompt.imprimir("[2] - " + Mensagem.READ);
	Prompt.imprimir("[3] - " + Mensagem.UPDATE);
	Prompt.imprimir("[4] - " + Mensagem.DELETE);
	Prompt.imprimir("[5] - " + Mensagem.VOLTAR);
	Integer opcao = Prompt.lerInteiro();

		switch(opcao){
			case 1:
				TelaCliente.create();
				break;
			case 2:
				TelaCliente.read();
				break;
			case 3:
				TelaCliente.update();
				break;
			case 4:
				TelaCliente.delete();
				break;
			case 5:
				TelaPrincipal.mostrar();
				break;
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaCliente.mostrar();
				break;
		}
	}

	public static void create(){
        
		// Lendo e guardando dados em variáveis

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_CLIENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
 
		if(ControleCliente.clienteExiste(CPF)){
				Prompt.separador();
				Prompt.imprimir(Mensagem.JA_EXISTE);
				Prompt.separador();
				Prompt.linhaEmBranco();
				Prompt.imprimir(ControleCliente.clienteEspecifico(CPF));
				TelaCliente.repeat();
				return;
			}
		String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        String endereco = Prompt.lerLinha(Mensagem.INFORME_ENDERECO);
		//MENSAGEM DE SUCESSO
		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.CLIENTE_CAD_SUCESSO);
		Prompt.separador();
		Prompt.linhaEmBranco();

		// Verificando se nome esta vazio

        if(!nome.isEmpty()) {

			/* Chamando a função adicionar da Classe ControleCliente, criando um objeto e passando
			 as variáveis como parâmetro para a criação do novo Cliente */
			 
        	ControleCliente.adicionar(new Cliente(nome, CPF, telefone, sexo, email, endereco));
        }
		Prompt.pressionarEnter();
		TelaCliente.repeat();
	}

	public static void read(){
		
		// Imprime uma mensagem de cabeçalho
		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_CLIENTES);
		Prompt.separador();
		
		// Adiciona uma linha em branco
		Prompt.linhaEmBranco();
		
		// Verifica se a lista de clientes está vazia
		if (Banco.clientes.isEmpty()) {
			// Se a lista de clientes estiver vazia, imprime uma mensagem informando que não há clientes
			Prompt.imprimir(Mensagem.NAO_HA_CLIENTES);
			Prompt.linhaEmBranco(); 
		} else {
			Prompt.imprimir(ControleCliente.listaClientes());
		}
		Prompt.pressionarEnter();
		TelaCliente.mostrar();
	}
	
	public static void update(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.UPDATE_CLIENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer cpfOriginal = Prompt.lerInteiro(Mensagem.CPF_ORIGINAL);


		if(!cpfOriginal.equals(null)) {
			Cliente clienteAlterado = ControleCliente.buscar(cpfOriginal);
			
			if(clienteAlterado != null) {
				Prompt.separador();
				Prompt.imprimir(Mensagem.NOVOS_DADOS);
				Prompt.separador();
				Prompt.linhaEmBranco();
				String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
				Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
				String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
				String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
				String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
				String endereco = Prompt.lerLinha(Mensagem.INFORME_ENDERECO);
				
				if(!nome.isEmpty() && !CPF.equals(null)) {
					clienteAlterado.setNome(nome);
					clienteAlterado.setCPF(CPF);
					clienteAlterado.setTelefone(telefone);
					clienteAlterado.setEmail(email);
					clienteAlterado.setSexo(sexo);
					clienteAlterado.setEndereco(endereco);
					
					ControleCliente.atualizar(cpfOriginal, clienteAlterado);
					Prompt.linhaEmBranco();
					Prompt.imprimir(Mensagem.ALTERADO_COM_SUCESSO);
					TelaCliente.read();
					return;
				} 
			} else {
				Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.CLIENTE_NAO_ENCONTRADO);
				TelaCliente.read();
				return;
			}	
	}
}

	public static void delete(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.DELETAR_CLIENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer CPF = Prompt.lerInteiro(Mensagem.CPF_DELETE);
		
		if(!CPF.equals(null)) {
			boolean clienteDeletado = ControleCliente.delete(CPF);
			Prompt.linhaEmBranco();
			if(clienteDeletado) {
				Prompt.imprimir(Mensagem.EXCLUIDO_COM_SUCESSO);
				TelaCliente.read();
				return;
			} else {
				Prompt.imprimir(Mensagem.CLIENTE_NAO_ENCONTRADO);
				TelaCliente.read();
				return;
			}
		}
	}

	public static void repeat(){

	// Menu pra escolher o que deseja fazer a seguir com recursão em caso de opção invalida
	Prompt.separador();
	Prompt.imprimir(Mensagem.REFAZER);
	Prompt.separador();
	Prompt.imprimir("[1] - " + Mensagem.SIM);
	Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
	Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
	Integer op = Prompt.lerInteiro();
	switch (op) {
		case 1:
			TelaCliente.create();
			break;
		case 2:
			TelaCliente.mostrar();
			break;
		case 3:
			Prompt.imprimir(Mensagem.FINALIZADO);
			break;
		default:
			Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
			TelaCliente.repeat();
			break;
	}
}
}
