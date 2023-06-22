package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jogador.CriarJogador;
import observer.CadastroObservadores;

public class ViewResultado {

	@FXML
	Label recordeLabel = new Label();

	@FXML
	Label labelResultado = new Label();

	public void setResultado(String nomeusuario, int pontos) {
		String pontuacao = Integer.toString(pontos);
		labelResultado.setText("Parabéns " + nomeusuario + ", você conseguiu " + pontuacao + " pontos!");

		CadastroObservadores cadastro = new CadastroObservadores(pontos);
		
		// se o recorde de pontuacao não foi batido o código abaixo retorna apenas uma string vazia

		recordeLabel.setText(cadastro.getTextLabel());

		CriarJogador jogador = new CriarJogador(nomeusuario, pontos);
		jogador.salvarJogador();
	}

}
