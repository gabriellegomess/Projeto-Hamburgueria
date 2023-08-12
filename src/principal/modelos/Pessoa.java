package principal.modelos;

public class Pessoa {
	
	private String nome;
	private Integer CPF;
	private String telefone;
	private String sexo;
	private String email;

	public Pessoa() {
	
	}
	
	public Pessoa(String nome, Integer CPF, String telefone, String sexo, String email) {
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.sexo = sexo;
		this.email = email;
	}

	//GETTERS e SETTERS
	
	//nome
	public void setNome( String nomeExterno ) {
		this.nome = nomeExterno;
	}
	
	public String getNome() {
		return nome;
	}
	
	//CPF
	public void setCPF( Integer CPFexterno )    {
		this.CPF = CPFexterno;
	}
	
	public Integer getCPF() {
		return CPF;
	}
	
	//telefone
	public void setTelefone( String telefoneExterno ) {
		this.telefone = telefoneExterno;
	}

	public String getTelefone() {
		return telefone;
	}
	
	//sexo
	public void setSexo( String sexoExterno ) {
		this.sexo = sexoExterno;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	//email
	public void setEmail( String emailExterno ) {
		this.email = emailExterno;
	}
	
	public String getEmail() {
		return email;
	}
	
	//resumo
	public String getResumo() {
		String resumoAux = ("Nome: "+ nome + "\n CPF: " + CPF + "\n Telefone: " + telefone + "\n Sexo: " + sexo + "\n Email: " + email);
		return resumoAux;
	}
}
