package gui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GamerTabela {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nomeJogador;
	private SimpleIntegerProperty pontos;

	public GamerTabela(int id, String nomeJogador, int pontos) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nomeJogador = new SimpleStringProperty(nomeJogador);
		this.pontos = new SimpleIntegerProperty(pontos);
	}


	public int getId() {
		return id.get();
	}


	public int getPontos(Integer id) {
		return pontos.get();
	}

	public String getNomeJogador(Integer id) {
		return nomeJogador.get();
	}

}
