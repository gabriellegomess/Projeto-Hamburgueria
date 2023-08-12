package principal.controles;
import principal.db.Banco;
import principal.modelos.Cliente;

/*
 * @Author Lucas Cardoso
 * @version 1.0 Abr 2023
 */

public class ControleCliente {

	public static void adicionar(Cliente cliente){
        Banco.clientes.add(cliente);
    }

    public static Cliente buscar(Integer cpf) {
		Cliente clienteRetorno = null;
		for (Cliente cliente : Banco.clientes) {
			if (cliente.getCPF().equals(cpf)) {
				clienteRetorno = cliente;
				break;
			}
		}
		return clienteRetorno;
	}

    /*Essas duas funções têm o mesmo nome, "atualizar", mas parâmetros diferentes. 
	A primeira função recebe um índice e o objeto "Cliente" que deve ser atualizado na lista. 
	A segunda função recebe uma string que é o nome original do cliente e o objeto "Cliente" atualizado.

    Quando a função é chamada, o Java determina qual das funções será chamada baseado nos parâmetros 
	que foram passados. Se os parâmetros correspondem aos da primeira função, ela é chamada; 
	se correspondem aos da segunda, a segunda é chamada.

    Por exemplo, se o índice do cliente que deve ser atualizado é conhecido, 
	a primeira função pode ser usada, mas se o nome original do cliente for usado como referência, 
	a segunda função pode ser usada. Isso permite maior flexibilidade no uso da função, 
	dependendo das informações disponíveis no momento em que é chamada. */

	public static void atualizar(Integer cpfOriginal, Cliente clienteAlterado) {
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getCPF().equals(cpfOriginal)) {
				Banco.clientes.set(i, clienteAlterado);
			    break;
			}
		}
	}

    public static boolean delete(Integer CPF) {
		boolean clienteDelete = false;
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getCPF().equals(CPF)) {
				Banco.clientes.remove(i);
				clienteDelete = true;
				break;
			}
		}
		return clienteDelete;
	}

	public static boolean clienteExiste(Integer CPF){
		for(Cliente cliente : Banco.clientes) {
			if(cliente.getCPF().equals(CPF)){
				return true;
			}
		}
		return false;
	}

	public static String clienteEspecifico(Integer CPF){
		for (Cliente cliente : Banco.clientes) {
			if(cliente.getCPF().equals(CPF)){
			// Monta uma string com as informações do cliente
			String infoCliente = "Nome: " + cliente.getNome() + "\n"
								+ "CPF: " + cliente.getCPF() + "\n"
								+ "Telefone: " + cliente.getTelefone() + "\n"
								+ "Email: " + cliente.getEmail() + "\n"
								+ "Sexo: " + cliente.getSexo() + "\n"
								+ "Endereço: " + cliente.getEndereco() + "\n";
								// Imprime as informações do cliente
			return infoCliente;
			}
	}
	return null;
}

	public static String listaClientes(){
		for (Cliente cliente : Banco.clientes) {
			// Monta uma string com as informações do cliente
			String infoCliente = "Nome: " + cliente.getNome() + "\n"
								+ "CPF: " + cliente.getCPF() + "\n"
								+ "Telefone: " + cliente.getTelefone() + "\n"
								+ "Email: " + cliente.getEmail() + "\n"
								+ "Sexo: " + cliente.getSexo() + "\n"
								+ "Endereço: " + cliente.getEndereco() + "\n";
								// Imprime as informações do cliente
			return infoCliente;
		}
		return null;
	}
}