package principal.controles;

import principal.db.Banco;
import principal.modelos.Produto;

import java.util.List;

public class ControleProduto {
	
	public static void adicionar(Produto produto){
        Banco.produtos.add(produto);
    }


    public static List<Produto> listar(){
        return Banco.produtos;
    }

    public static Produto buscarPorId(int idExterno){
        for (Produto produto : Banco.produtos) {
            if(produto.getId() == idExterno){
                return produto;
            }

        }

        return null;
    }

    public static Produto buscarPorNome(String nome){
        Produto produtoRetorno = null;
        for (Produto produto : Banco.produtos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
                produtoRetorno = produto;
                break;
            }
        }

        return produtoRetorno;
    }

    

    // public static void atualizar(int indexAlterar, Produto produtoAlterado) {
	// 	Banco.produtos.set(indexAlterar, produtoAlterado);
	// }

	public static void atualizar(int idOriginal, Produto produtoAlterado) {
		for (int i = 0; i < Banco.produtos.size(); i++) {
			Produto produto = Banco.produtos.get(i);
			if (produto.getId() == idOriginal) {
				Banco.produtos.set(i, produtoAlterado);
			    break;
			}
		}
	}

    public static boolean excluir(Integer id) {
        for (Produto produto : Banco.produtos) {
        if (produto.getId() == id) {
        Banco.produtos.remove(produto);
        return true;
        }
        }
        return false;
        }
}
