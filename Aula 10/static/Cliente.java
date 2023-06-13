public class Cliente {
	private String nome;
	private String email;
	public static int qtdeClientes;
	
	public Cliente(){
		qtdeClientes++;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String n){
		this.nome = n;
	}

	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String e){
		this.email = e;
	}

}
