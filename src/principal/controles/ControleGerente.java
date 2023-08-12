package principal.controles;
import principal.db.Banco;
import principal.modelos.Gerente;

public class ControleGerente {

	public static void adicionar(Gerente gerente){
        Banco.gerentes.add(gerente);
    }

    public static Gerente buscar(String nome) {
		Gerente gerenteRetorno = null;
		for (Gerente gerente : Banco.gerentes) {
			if (gerente.getNome().equalsIgnoreCase(nome)) {
				gerenteRetorno = gerente;
				break;
			}
		}
		return gerenteRetorno;
	}

	public static Gerente buscarCPF(int CPF) {
		Gerente gerenteRetorno = null;
		for (Gerente gerente : Banco.gerentes) {
			if (gerente.getCPF().equals(CPF)) {
				gerenteRetorno = gerente;
				break;
			}
		}
		return gerenteRetorno;
	}

    // public static void atualizar(int indexAlterar, Gerente gerenteAlterado) {
	// 	Banco.gerentes.set(indexAlterar, gerenteAlterado);
	// }

	public static void atualizar(int CPFalterado, Gerente gerenteAlterado) {
		for (int i = 0; i < Banco.gerentes.size(); i++) {
			Gerente gerente = Banco.gerentes.get(i);
			if (gerente.getCPF().equals(CPFalterado)) {
				Banco.gerentes.set(i, gerenteAlterado);
			    break;
			}
		}
	}

    public static boolean delete(Integer CPF) {
		boolean gerenteDelete = false;
		for (int i = 0; i < Banco.gerentes.size(); i++) {
			Gerente gerente = Banco.gerentes.get(i);
			if (gerente.getCPF().equals(CPF)) {
				Banco.gerentes.remove(i);
				gerenteDelete = true;
				break;
			}
		}
		return gerenteDelete;
	}

	public static boolean gerenteExiste(Integer CPF){
		for(Gerente gerente : Banco.gerentes) {
			if(gerente.getCPF().equals(CPF)){
				return true;
			}
		}
		return false;
	}
}
