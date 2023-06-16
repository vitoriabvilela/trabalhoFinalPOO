package jogador;

public class CriarJogador {
	
	GamerDAO gamerDAO = new GamerDAO();
	String nome;
	int pontos;
	
	public CriarJogador(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}
	public void salvarJogador() {
		Gamer gamer = new Gamer(this.nome, this.pontos);
		gamerDAO.salvarJogador(gamer);
	}
	
}
