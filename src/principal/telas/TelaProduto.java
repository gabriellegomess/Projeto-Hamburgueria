package principal.telas;
import principal.controles.ControleProduto;
import principal.db.Banco;
import principal.modelos.Produto;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaProduto {
	
	public static void mostrar(){
        
		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_PRODUTO);
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
			TelaProduto.create();
			break;
		case 2:
			TelaProduto.read();
			break;
		case 3:
			TelaProduto.update();
			break;
		case 4:
			TelaProduto.delete();
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
	
	public static void create(){

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_PRODUTO);
		Prompt.separador();
		Integer id = Prompt.lerInteiro(Mensagem.INFORME_ID);
         // verifica se o ID já existe na lista de produtos existentes
    	boolean idJaExiste = Banco.produtos.stream()
        .map(Produto::getId)
        .anyMatch(id::equals);

		/*Neste código, a variável id é definida como Integer, e para verificar se o id já existe é
		é usada uma expressão lambda com o método anyMatch(), 
		que verifica se algum elemento da lista corresponde ao id.
		A primeira chamada da cadeia de métodos, Banco.produtos.stream(), transforma a lista de 
		produtos em um fluxo de elementos.

		Em seguida, o método map(Produto::getId) mapeia cada elemento do fluxo para o seu ID 
		correspondente, que é um inteiro.

		Finalmente, o método anyMatch(id::equals) verifica se algum elemento do fluxo é igual ao id 
		informado. Para isso, é utilizado o método equals() do objeto id, que recebe como argumento 
		outro objeto do tipo Integer. O método id::equals é uma forma simplificada de criar um lambda 
		que faz a comparação entre o id e o elemento do fluxo.

		O resultado desta operação é um valor booleano, que é atribuído à variável idJaExiste. 
		Se o valor for true, significa que já existe um produto na lista com o mesmo ID informado.*/

   		if (idJaExiste) {
        Prompt.imprimir(Mensagem.ID_JA_EXISTE);
    	} else {
        	String nome = Prompt.lerLinha(Mensagem.INFORME_NOME_PRODUTO);
        	String marca = Prompt.lerLinha(Mensagem.INFORME_MARCA);
        	double preco  = Prompt.lerDecimal(Mensagem.INFORME_PRECO);
        	int codBarra = Prompt.lerInteiro(Mensagem.INFORME_CODBARRA);
        
        if(!nome.isEmpty()) {
            ControleProduto.adicionar(new Produto(id, nome, marca, preco, codBarra));
        }
    	}
		Prompt.pressionarEnter();
        TelaProduto.repeat();
	}
	
	public static void repeat(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.NOVO_PRODUTO);
		Prompt.separador();
		Prompt.imprimir("[1] - " + Mensagem.SIM);
		Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
		Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
		Integer op = Prompt.lerInteiro();
		switch (op) {
			case 1:
				TelaProduto.create();
				break;
			case 2:
				TelaProduto.mostrar();
				break;
			case 3:
				Prompt.imprimir(Mensagem.FINALIZADO);
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaProduto.repeat();
				break;
		}
    }
	
	public static void read(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_PRODUTOS);
		Prompt.separador();
		
		Prompt.linhaEmBranco();
		
		if (Banco.produtos.isEmpty()) {
			
			Prompt.imprimir(Mensagem.NAO_HA_PRODUTOS); 
		} else {
			
			for (Produto produto : Banco.produtos) {
				String infoProduto = "ID: " + produto.getId() + "\n"
									+ "Nome: " + produto.getNome() + "\n"  
									+ "Marca: " + produto.getMarca() + "\n"
									+ "Preço: " + produto.getPreco() + "\n"
									+ "Código de Barras: " + produto.getCodBarra() + "\n";
				Prompt.imprimir(infoProduto);
			}
		}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaProduto.mostrar();
	}

	public static void update(){
		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.UPDATE_PRODUTO);
		Prompt.separador();
		Integer idOriginal = Prompt.lerInteiro(Mensagem.ID_ORIGINAL_PRODUTO);
		if(idOriginal != null) {
			Produto produtoAlterado = ControleProduto.buscarPorId(idOriginal);
			
			if(produtoAlterado != null) {
				Prompt.imprimir(Mensagem.NOVOS_DADOS_PRODUTO);
				Prompt.linhaEmBranco();
				Integer id = Prompt.lerInteiro(Mensagem.INFORME_ID);
				String nome = Prompt.lerLinha(Mensagem.INFORME_NOME_PRODUTO);
				String marca = Prompt.lerLinha(Mensagem.INFORME_MARCA);
				double preco = Prompt.lerDecimal(Mensagem.INFORME_PRECO);
				int codBarra = Prompt.lerInteiro(Mensagem.INFORME_CODBARRA);
				
				boolean mesmoID = id != null && id.equals(produtoAlterado.getId());
            	boolean idJaExiste = !mesmoID && Banco.produtos.stream()
                    .map(Produto::getId)
                    .anyMatch(id::equals);

            	if (idJaExiste) {
                	if (mesmoID) {
                    	// permite a atualização do produto com o mesmo ID
                	} else {
                    	Prompt.imprimir(Mensagem.ID_JA_EXISTE);
						Prompt.pressionarEnter();
                    	TelaProduto.mostrar();
                	}
            }

            	if(id != null && !nome.isEmpty()) {
                	produtoAlterado.setId(id);
                	produtoAlterado.setNome(nome);
                	produtoAlterado.setMarca(marca);
                	produtoAlterado.setPreco(preco);
                	produtoAlterado.setCodBarra(codBarra);

                ControleProduto.atualizar(idOriginal, produtoAlterado);
                Prompt.linhaEmBranco();
                Prompt.imprimir(Mensagem.PRODUTO_ALTERADO_COM_SUCESSO);
            	}
			} else {
				Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
			}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaProduto.mostrar();
		}
	}

	public static void delete() {
		Prompt.separador();
		Prompt.imprimir(Mensagem.MSG_EXCLUSAO_PRODUTO);
		Prompt.separador();
		Integer id = Prompt.lerInteiro(Mensagem.INFORME_ID);
		boolean excluiu = ControleProduto.excluir(id);
		if(excluiu) {
		Prompt.imprimir(Mensagem.PRODUTO_EXCLUIDO_SUCESSO);
		} else {
		Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
		}
		Prompt.pressionarEnter();
		TelaProduto.repeatDelete();
	}

	public static void repeatDelete(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.DELETAR_OUTRO_PRODUTO);
		Prompt.separador();
		Prompt.imprimir("[1] - " + Mensagem.SIM);
		Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
		Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
		Integer op = Prompt.lerInteiro();
		switch (op) {
			case 1:
				TelaProduto.delete();
				break;
			case 2:
				TelaProduto.mostrar();
				break;
			case 3:
				Prompt.imprimir(Mensagem.FINALIZADO);
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaProduto.repeat();
				break;
		}
    }

}
