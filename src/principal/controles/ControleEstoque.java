package principal.controles;

// import java.io.File;
// import java.util.Formatter;

import principal.db.Banco;
import principal.modelos.ItemEstoque;
import principal.modelos.Produto;
import principal.telas.TelaEstoque;
import principal.telas.TelaPrincipal;
import principal.util.Mensagem;
import principal.util.Prompt;

public class ControleEstoque {

    public static void adicionar(ItemEstoque item){
        Banco.itensEstoque.add(item);
    }

    public static boolean delete(int id){
        boolean produtoExcluido = false;
        for (ItemEstoque produto : Banco.itensEstoque) {
            if(produto.getId() == id){
                Banco.itensEstoque.remove(produto);
                produtoExcluido = true;
                break;
            }
        }
        return produtoExcluido;
    }

    public static boolean produtoExiste(int idProduto){
        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId().equals(idProduto)){
                return true;
            }   
        }
        return false;
    }

    public static void listarId(){
        for (Produto produto : Banco.produtos) {
            Prompt.imprimir("ID: " + produto.getId() + "\nProduto: " + produto.getNome() + "\nMarca: " + produto.getMarca() + "\n");
        }
    }

    public static void alterarQuantidade(int id, int qtde){
        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId() == id){
                item.setQtde(qtde);
            }
        }
    }

    public static void ListarEstoque(){
        for (ItemEstoque produto : Banco.itensEstoque) {
            String info = "\nID: " + produto.getId() +"\n"
                        + "Produto: " + produto.getProduto().getNome() + "\n"
                        + "Quantidade: " + produto.getQtde();

            Prompt.imprimir(info);
        }
    }

    public static void Cadastrar(boolean control, Integer idProduto){
        if(!control){

            if(idProduto != null) {
                
                Produto produto = ControleProduto.buscarPorId(idProduto);
                
                if(produto == null){
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.ID_INVALIDA);
                } else {
                    Integer qtde = Prompt.lerInteiro(Mensagem.INFORME_QUANTIDADE);
                    ItemEstoque item = new ItemEstoque();
                    item.setId(idProduto);
                    item.setProduto(produto);
                    item.setQtde(qtde);
            
                    ControleEstoque.adicionar(item);
    
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.PRODUTO_CADASTRADO_ESTOQUE);
                } 
            }
        } else {

            Prompt.linhaEmBranco();
            Prompt.imprimir(Mensagem.PRODUTO_EXISTENTE_ESTOQUE);
        }
    }

    public static void Update(Integer idProduto){
        if(idProduto != null){

            boolean produtoExiste = ControleEstoque.produtoExiste(idProduto);

            if(produtoExiste){

                Integer qtde = Prompt.lerInteiro(Mensagem.QTDE_ESTOQUE);

                ControleEstoque.alterarQuantidade(idProduto, qtde);

                Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.ESTOQUE_ALTERADO);
                Prompt.separador();
                Prompt.imprimir(Mensagem.ESTOQUE_ATUAL);
                ControleEstoque.ListarEstoque();
                Prompt.separador();
            } else {
                Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
            }
        }
    }


    public static void Delete(Integer idProduto){
        if(idProduto != null){
            boolean estoqueExcluido = ControleEstoque.delete(idProduto);
			Prompt.linhaEmBranco();
			if(estoqueExcluido) {
                Prompt.separador();
				Prompt.imprimir(Mensagem.ESTOQUE_EXCLUIDO);
                Prompt.separador();
                if(Banco.itensEstoque.isEmpty()){
                    Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
                }else{
                    Prompt.imprimir(Mensagem.ESTOQUE_ATUAL);
                    ControleEstoque.ListarEstoque();
                }
                Prompt.separador();
			} else {
				Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
			}
        }
    }

    public static void repeat(String control){
    
        Prompt.separador();
        if(control.equals("create")){
            Prompt.imprimir(Mensagem.CADASTRAR_OUTRO);
        } else if(control.equals("update")){
            Prompt.imprimir(Mensagem.ALTERAR_OUTRO);
        } else if(control.equals("delete")){
            Prompt.imprimir(Mensagem.DELETAR_OUTRO);
        }
        
        Prompt.separador();
        Prompt.imprimir("[1] - " + Mensagem.SIM);
	    Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
	    Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
        Integer op = Prompt.lerInteiro();

        switch (op) {
            case 1:
                if(control.equals("create")){
                    TelaEstoque.create();;
                } else if(control.equals("update")){
                    TelaEstoque.update();;
                } else if(control.equals("delete")){
                    TelaEstoque.delete();
                }
                break;
            case 2:
                TelaEstoque.mostrar();
                break;
            case 3:
                Prompt.imprimir(Mensagem.FINALIZADO);
                break;
            default:
                Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                TelaEstoque.mostrar();
                break;
        }
    }

    public static void MenuEstoque(){
        
        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MENU_ESTOQUE);
        Prompt.separador();
        Prompt.linhaEmBranco();
        Prompt.imprimir("[1] - " + Mensagem.CREATE);
        Prompt.imprimir("[2] - " + Mensagem.READ);
        Prompt.imprimir("[3] - " + Mensagem.UPDATE);
        Prompt.imprimir("[4] - " + Mensagem.DELETE);
        Prompt.imprimir("[5] - " + Mensagem.VOLTAR);
        Integer opcao = Prompt.lerInteiro();

            switch (opcao) {
                case 1:
                    TelaEstoque.create();
                    break;
                case 2:
                    TelaEstoque.read();
                    break;
                case 3:
                    TelaEstoque.update();
                    break;
                case 4:
                    TelaEstoque.delete();
                    break;
                case 5:
                    TelaPrincipal.mostrar();
                    break;
                default:
                    Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                    TelaPrincipal.mostrar();
                    break;
            }
    }
}