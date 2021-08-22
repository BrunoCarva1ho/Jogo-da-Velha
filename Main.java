package exercicio02;

public class Main {
	public static void main(String[]args) {
		
		Jogo_da_velha jogoV = new Jogo_da_velha();
		int teste='s';	
		do {
			jogoV.exibir();
			jogoV.jogar(jogoV.getJogodavelha());
			
			if(jogoV.vencedor(jogoV.getJogodavelha()) == 1 || jogoV.vencedor(jogoV.getJogodavelha()) == 2) {
				teste ='n'; 
				jogoV.exibir();
			}
			else if(jogoV.vencedor(jogoV.getJogodavelha()) == 3) {
				teste='n';
				jogoV.exibir();
			}
			
		}while(teste!='n');
		
	}
}
