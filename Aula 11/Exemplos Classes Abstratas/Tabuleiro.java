public class Tabuleiro {
	
	public static void main(String[] args) {	
		//Peca peca1 = new Peca();  //não pode pois é classe abstrada
		Peao p1 = new Peao();
		p1.setCor("B");

		Peao p2 = new Peao();
		p2.setCor("P");
		
		Bispo b1 = new Bispo();
		b1.setCor("B");
		
		System.out.println("Peao 1:");
		p1.mover(2);
		System.out.println("Peao 2:");
		p2.mover(1);
		System.out.println("Bispo 1:");
		b1.mover("FD", 5);
		System.out.println("Peao 2:");
		p2.comer("D");
		System.out.println("Bispo 1:");
		b1.comer("TE", 3);
	}
}