package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;

import principal.controles.ControleEstoque;
import principal.db.Banco;

/*
 * @version 1.0 Abr 2023
 * @author Vinícius Cordeiro Nocera
 */

public class TelaEstoque {

    public static void mostrar(){

        ControleEstoque.MenuEstoque();
    }

    public static void create(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_ESTOQUE);
        Prompt.separador();

        ControleEstoque.listarId();

        Prompt.linhaEmBranco();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_CADASTRO);

        boolean control = ControleEstoque.produtoExiste(idProduto);

        ControleEstoque.Cadastrar(control, idProduto);

        Prompt.linhaEmBranco();
        Prompt.pressionarEnter();
		ControleEstoque.repeat("create");
    }

    public static void read(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.LISTA_ESTOQUE);
        Prompt.separador();

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
        } else {
            ControleEstoque.ListarEstoque();
        }

        Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaEstoque.mostrar();
    }

    public static void update(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.UPDATE_ESTOQUE);
        Prompt.separador();

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
            TelaEstoque.mostrar();
        } else {

            ControleEstoque.ListarEstoque();
    
            Prompt.linhaEmBranco();
            Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_ALTERAR);
    
            ControleEstoque.Update(idProduto);
    
            Prompt.linhaEmBranco();
            Prompt.pressionarEnter();
            ControleEstoque.repeat("update");
        }
    }

    public static void delete(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.EXCLUIR_ESTOQUE);
        Prompt.separador();

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
            TelaEstoque.mostrar();
        } else {

            ControleEstoque.ListarEstoque();

            Prompt.linhaEmBranco();
            Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_EXCLUIR_ESTOQUE);

            ControleEstoque.Delete(idProduto);

            Prompt.linhaEmBranco();
            Prompt.pressionarEnter();

            ControleEstoque.repeat("delete");
        }
    }
}


