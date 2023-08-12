package principal.telas;

import java.time.LocalDate;

import principal.controles.ControleGerente;
import principal.db.Banco;
import principal.modelos.Gerente;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaGerente {
	
	public static void mostrar(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_GERENTE);
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
					TelaGerente.create();
					break;
				case 2:
					TelaGerente.read();
					break;
				case 3:
					TelaGerente.update();
					break;
				case 4:
					TelaGerente.delete();
					break;
				case 5:
					TelaPrincipal.mostrar();
					break;
				default:
					Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
					TelaGerente.mostrar();
					break;
			}
	}

	public static void create(){
        
		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_GERENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
		if(ControleGerente.gerenteExiste(CPF)){
				Prompt.separador();
				Prompt.imprimir(Mensagem.JA_EXISTE_GERENTE);
				Prompt.separador();
				Prompt.linhaEmBranco();
				for (Gerente gerente : Banco.gerentes) {
					if(gerente.getCPF().equals(CPF)){
					String infoGerente = "Nome: " + gerente.getNome() + "\n"
										+ "CPF: " + gerente.getCPF() + "\n"
										+ "Telefone: " + gerente.getTelefone() + "\n"
										+ "Email: " + gerente.getEmail() + "\n"
										+ "Sexo: " + gerente.getSexo() + "\n"
                                        + "Data de Admissao: " + gerente.getDataAdmissao() + "\n"
                                        + "Salário: " + gerente.getSalario() + "\n";
					Prompt.imprimir(infoGerente);
					}
				}
				TelaGerente.refazer();
				return;
			}
		String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        LocalDate dataAdmissao = Prompt.lerData(Mensagem.INFORME_DATA_ADMISSAO);
        double salario = Prompt.lerDecimal(Mensagem.INFORME_SALARIO);

        if(!nome.isEmpty()) {
			 ControleGerente.adicionar(new Gerente(nome, CPF, telefone, sexo, email, dataAdmissao, salario));
             // Gerente(String nome, Integer CPF, String telefone, String sexo, String email, LocalDate dataAdmissao, BigDecimal salario)
        }
		Prompt.pressionarEnter();
		TelaGerente.refazer();
		
	}

	public static void read(){
		
		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_GERENTES);
		Prompt.separador();
		
		Prompt.linhaEmBranco();
		
		if (Banco.gerentes.isEmpty()) {
			Prompt.imprimir(Mensagem.NAO_HA_GERENTES);
			Prompt.linhaEmBranco(); 
		} else {
			for (Gerente gerente : Banco.gerentes) {
				String infoGerente = "Nome: " + gerente.getNome() + "\n"
									+ "CPF: " + gerente.getCPF() + "\n"
									+ "Telefone: " + gerente.getTelefone() + "\n"
									+ "Email: " + gerente.getEmail() + "\n"
									+ "Sexo: " + gerente.getSexo() + "\n"
                                    + "Data de Admissao: " + gerente.getDataAdmissao() + "\n"
                                    + "Salário: " + gerente.getSalario() + "\n";
				Prompt.imprimir(infoGerente);
			}
		}
		Prompt.pressionarEnter();
		TelaGerente.mostrar();
	}
	
	public static void update(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.UPDATE_GERENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer CPForiginal = Prompt.lerInteiro(Mensagem.INFORME_CPF);
		if(!CPForiginal.equals(null)) {
			Gerente gerenteAlterado = ControleGerente.buscarCPF(CPForiginal);
			
			if(gerenteAlterado != null) {
				Prompt.separador();
				Prompt.imprimir(Mensagem.NOVOS_DADOS_GERENTE);
				Prompt.separador();
				Prompt.linhaEmBranco();
				String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
				Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
				String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
				String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
				String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
                LocalDate dataAdmissao = Prompt.lerData(Mensagem.INFORME_DATA_ADMISSAO);
                double salario = Prompt.lerDecimal(Mensagem.INFORME_SALARIO);
				
				if(!nome.isEmpty() && !CPF.equals(null)) {
					gerenteAlterado.setNome(nome);
					gerenteAlterado.setCPF(CPF);
					gerenteAlterado.setTelefone(telefone);
					gerenteAlterado.setEmail(email);
					gerenteAlterado.setSexo(sexo);
                    gerenteAlterado.setDataAdmissao(dataAdmissao);
                    gerenteAlterado.setSalario(salario);
					
					ControleGerente.atualizar(CPForiginal, gerenteAlterado);
					Prompt.linhaEmBranco();
					Prompt.imprimir(Mensagem.ALTERADO_COM_SUCESSO_GERENTE);
					TelaGerente.read();
					return;
				} 
			} else {
				Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.GERENTE_NAO_ENCONTRADO);
				TelaGerente.read();
				return;
			}		
	}
}

	public static void delete(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.DELETAR_GERENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Integer CPF = Prompt.lerInteiro(Mensagem.CPF_DELETE_GERENTE);
		
		if(!CPF.equals(null)) {
			boolean gerenteDeletado = ControleGerente.delete(CPF);
			Prompt.linhaEmBranco();
			if(gerenteDeletado) {
				Prompt.imprimir(Mensagem.EXCLUIDO_COM_SUCESSO_GERENTE);
				TelaGerente.read();
				return;
			} else {
				Prompt.imprimir(Mensagem.GERENTE_NAO_ENCONTRADO);
				TelaGerente.read();
				return;
			}
		}
	}

	public static void refazer(){

	Prompt.separador();
	Prompt.imprimir(Mensagem.REFAZER);
	Prompt.separador();
	Prompt.imprimir("[1] - " + Mensagem.SIM);
	Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
	Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
	Integer op = Prompt.lerInteiro();
	switch (op) {
		case 1:
			TelaGerente.create();
			break;
		case 2:
			TelaGerente.mostrar();
			break;
		case 3:
			Prompt.imprimir(Mensagem.FINALIZADO);
			break;
		default:
			Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
			TelaGerente.refazer();
			break;
	}
}
}
