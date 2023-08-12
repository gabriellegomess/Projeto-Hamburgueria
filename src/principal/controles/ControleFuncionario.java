package principal.controles;

import principal.db.Banco;
import principal.modelos.Funcionario;

public class ControleFuncionario {
    
	// funcionario é adicionado à lista de funcionários no banco de dados
    public static void adicionar(Funcionario funcionario){
        Banco.funcionarios.add(funcionario);
    }

//buscar no banco de dados a partir do nome se o funcionário existe
    public static Funcionario buscar(Integer cpf) {
		//iniciando a variavel no null
        Funcionario funcionarioRetorno = null;
        for (Funcionario funcionario : Banco.funcionarios) {
			//Verifica-se se o nome do funcionário atual, obtido através do método "getNome()", é igual ao nome fornecido como parâmetro
            if (funcionario.getCPF().equals(cpf)) {
                funcionarioRetorno = funcionario;
				//A variável "funcionarioRetorno" recebe o valor do funcionário atual e o loop é interrompido
                break;
            }
        }
		//O objeto "funcionarioRetorno" é retornado pela função. Se nenhum funcionário com o nome correspondente for encontrado, o valor retornado será "null".
        return funcionarioRetorno;
    }


    //duas funções com o mesmo nome porém com parametros diferentes ou seja, se os parametros passados
    //corresponderem aos parametros da primeira função se o índice do funcionario que deve ser atualizado é 
    //conhecido, a primeira função pode ser usada, mas se o nome original do funcionario for usado como referência, a segunda função pode ser usada.

	public static void atualizar(Integer cpfOrigem, Funcionario funcionarioAlterado) {
		for (int i = 0; i < Banco.funcionarios.size(); i++) {
			//vai procura no banco de dados se o cpf do funcionario existe 
			Funcionario funcionario = Banco.funcionarios.get(i);
			if (funcionario.getCPF().equals(cpfOrigem)) {
				//realiza as alterações
				Banco.funcionarios.set(i, funcionarioAlterado);
			    break;
			}
		}
	}

    //recebe uma string CPF que vai ser usada como parametro para exclusão
    //mas poderia ser um id, um cpf, algo especifico de um determinado funcionario
    public static boolean excluir(Integer CPF) {
        //atribui o valor falso para indicar que ninguém foi excluido
		boolean funcionarioExcluido = false;
        //percorrer o banco de funcionarios em busca do q tenha o CPF usado no parametro
		for (int i = 0; i < Banco.funcionarios.size(); i++) {
			Funcionario funcionario = Banco.funcionarios.get(i);
			if (funcionario.getCPF().equals(CPF)) {
				Banco.funcionarios.remove(i);
                //se o CPF for encontrado na lista ele vai ser removido 
                //mostrando q algm foi excluido 
				funcionarioExcluido = true;
				break;
			}
		}
		return funcionarioExcluido;
	}

    public static boolean funcionarioExiste(Integer CPF){
        //verificar no banco de dados se ja existe esse cpf
		for(Funcionario funcionario : Banco.funcionarios) {
			if(funcionario.getCPF().equals(CPF)){
				//se o funcionário for encontrado no banco de dados ele retorna true
				return true;
			}
		}
		//nenhum funcionário foi encontrado no banco de dados
		return false;
	}



}

