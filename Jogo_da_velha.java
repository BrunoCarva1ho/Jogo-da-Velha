package exercicio02;
import java.util.Scanner;

public class Jogo_da_velha {
	
	private char jogodavelha[][] = new char [3][3];
	
	public char[][] getJogodavelha() {
		return jogodavelha;
	}

	public void setJogodavelha(char[][] jogodavelha) {
		this.jogodavelha = jogodavelha;
	}

	public static int getJogador() {
		return jogador;
	}

	public static void setJogador(int jogador) {
		Jogo_da_velha.jogador = jogador;
	}

	//CONSTRUTOR *****
	public Jogo_da_velha() {
		
		for(int i=0;i< this.jogodavelha.length;i++)
			for(int j=0;j<this.jogodavelha.length;j++)
				this.jogodavelha[i][j] = '0';
		
	}
	
	//EXIBIR GRADE *****
	public void exibir() {
		for(int i=0;i< this.jogodavelha.length;i++) {
			for(int j=0;j<this.jogodavelha.length;j++)
				System.out.print("_"+jogodavelha[i][j]+"_"+"|");
			System.out.println();
		}
	}	
	
	//COLETAR A POSICÇÃO A SER MARCADA NA GRADE *****
	public static int jogador = 1;
	public void jogar(char jogodavelha[][]) {
		
		int linha,coluna,teste=2;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Vez do jogador "+jogador);
		
		do {
			System.out.println("Qual Linha e coluna você quer marcar:");
				System.out.print("linha: ");
				linha = ler.nextInt();
				System.out.print("coluna: ");
				coluna = ler.nextInt();
				linha--; coluna--;
				
			if(jogodavelha[linha][coluna] != '0') {
				System.out.println("Essa casa ja foi marcada, escolha outra");
				teste =1;
			}
			else
				teste =2;
			
		}while(teste!=2);
			
			marcarPosicao(jogodavelha,linha,coluna,jogador);
			jogador++;
			if(jogador == 3)
				jogador=1;	
	}
	
	//MARCAR POSIÇÃO NA GRADE *****
	public void marcarPosicao(char jogodavelha[][], int linha, int coluna, int jogador) {	
		if(jogador==1)
			jogodavelha[linha][coluna] = 'X';
		else if(jogador==2)
			jogodavelha[linha][coluna] = 'O';
	}
	
	//TESTA RESULTADO *****
	public int vencedor(char jogodavelha [][]) {
		
		int vencedor1diagonal=0, vencedor2diagonal=0;
		int vencedor1diagonalsecundaria=0, vencedor2diagonalsecundaria=0;
		int i=0,j=0;
		int coluna = jogodavelha.length;
		
		for( i=0;i<jogodavelha.length; i++) {
			int vencedor1linha=0,vencedor2linha=0;
			int vencedor1coluna=0, vencedor2coluna=0;
			coluna--;
			
				for(j=0;j<jogodavelha.length;j++) {
				
					//LINHA **********************
					if(jogodavelha[i][j] == 'X' )
						vencedor1linha++;
					if(jogodavelha[i][j]== 'O')
						vencedor2linha++;
				
					//COLUNA *******************
					if(jogodavelha[j][i] =='X') 
						vencedor1coluna++;
					if(jogodavelha[j][i] == 'O')
						vencedor2coluna++;
				}
				
			//DIAGONAL ************************
			if(jogodavelha[i][i]=='X')
				vencedor1diagonal++;
			if(jogodavelha[i][i]=='O')
				vencedor2diagonal++;
	
			//DIAGONAL SECUNDARIA ************
			if(jogodavelha[i][coluna] == 'X')
				vencedor1diagonalsecundaria++;
			if(jogodavelha[i][coluna] == 'O')
				vencedor2diagonalsecundaria++;
			
			//CONCLUSÃO ***********************
			if(vencedor1linha==3 || vencedor1diagonal==3 || vencedor1coluna==3 || vencedor1diagonalsecundaria==3)
			{
				System.out.println("O JOGADOR 1 FOI O VENCEDOR! GGWP!");
				return 1;
			}
			else if(vencedor2linha==3 || vencedor2diagonal==3 || vencedor2coluna==3 || vencedor2diagonalsecundaria==3) 
			{
				System.out.println("O JOGADOR 2 FOI O VENCEDOR! GGWP! ");
				return 2;
			}
		}
		
		//TESTAR EMPATE **********************
		int casas=0;
			for(i=0;i<jogodavelha.length;i++) {
				for(j=0;j<jogodavelha.length;j++) {
					if(jogodavelha[i][j] != '0')
						casas++;
				}
			}
		
			if(casas==9) {
				System.out.println("O JOGO DEU EMPATE! GGWP!");
				return 3;
			}
		return 0;
	}
}
