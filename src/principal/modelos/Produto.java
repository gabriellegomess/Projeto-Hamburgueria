package principal.modelos;


public class Produto  {

    private int id;
    private String nome;
    private String marca;
    private double preco;
    private int codBarra;
    
    public Produto(int id, String nome, String marca, double preco, int codBarra) {
        this.id = id;
    	this.nome = nome;
    	this.marca = marca;
    	this.preco = preco;
    	this.codBarra = codBarra;
    }

    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	//nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //marca
    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    //preco
    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    //codBarra
    public int getCodBarra(){
        return codBarra;
    }

    public void setCodBarra(int codBarra){
        this.codBarra = codBarra;
    }

    
}