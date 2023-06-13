public class Bispo extends Peca {
	
	/** 
	@param String direcao: a direcao do movimento
	@param int casas: a quantidade de casas

	Direcao pode ser:
		FD: Frente a direita
		FE:
		TD:
		TE:
	*/
	public void mover(String direcao, int casas){
		System.out.println("Movendo " + casas 
			+ " para a direcao " + direcao);
	}
	
	/**
	@param String direcao: a direcao do movimento
	@param int casas: a quantidade de casas
	*/
	public void comer(String direcao, int casas){
		System.out.println("Comendo peca adversaria");
		this.mover(direcao, casas);
	}
}








