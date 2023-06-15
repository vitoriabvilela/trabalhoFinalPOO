package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewResultado {
	
		
	@FXML
	Label labelResultado = new Label();
	
		public void setResultado(String nomeusuario, int pontos) {
			String pontuacao = Integer.toString(pontos);
			labelResultado.setText("Parabéns " + nomeusuario +", você conseguiu " + pontuacao + " pontos!");	
			
			CriarJogador jogador = new CriarJogador(nomeusuario, pontos);
			jogador.salvarJogador();
		}
		
			
	
	
}
