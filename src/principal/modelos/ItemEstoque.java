package principal.modelos;

public class ItemEstoque {

    private Integer id;
    private Produto produto;
    private Integer qtde;


    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQtde() {
        return qtde;
    }
    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }
}
