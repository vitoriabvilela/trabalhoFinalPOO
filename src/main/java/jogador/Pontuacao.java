package jogador;

public class Pontuacao {
	
	int pontos = 0; 
	
	public int pontua() {
		pontos = pontos + 1;
		return pontos;
	}
	
	public int getPontos() {
		return pontos;
	}
}
