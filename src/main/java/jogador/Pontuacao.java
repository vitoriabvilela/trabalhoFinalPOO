package jogador;

import observer.Observer;

public class Pontuacao implements Observer {
	
	int pontos = 0; 
	
	public int pontua() {
		pontos = pontos + 1;
		return pontos;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void notify(int pontuacao) {
		System.out.println("Novo recorde: " + pontuacao);
	}
	
}
