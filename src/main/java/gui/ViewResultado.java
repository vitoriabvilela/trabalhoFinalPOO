package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jogador.CriarJogador;
import jogador.Pontuacao;
import observer.LabelRecorde;
import observer.RecordePontuacao;

public class ViewResultado{
	
	@FXML
	Label recordeLabel = new Label();
	
	@FXML
	Label labelResultado = new Label();
	
		public void setResultado(String nomeusuario, int pontos) {
			String pontuacao = Integer.toString(pontos);
			labelResultado.setText("Parabéns " + nomeusuario +", você conseguiu " + pontuacao + " pontos!");	
			
			//cadastro observer
			RecordePontuacao recorde = new RecordePontuacao(); 
			
			//observadores
			Pontuacao observador = new Pontuacao();
			LabelRecorde label = new LabelRecorde();

			//registrei os observadores
			recorde.registraObserver(observador);
			recorde.registraObserver(label);
			
			recorde.atualizarPontuacao(pontos);
			
			//se houve recorde de pontuacao, o observer avisa os observadores
			//no notify do observador label ele altera uma String que é inicialmente vazia
			//para um texto avisando que o recorde foi batido
			//logo, se o recorde não foi batido o código abaixo retorna apenas uma string vazia
			
			recordeLabel.setText(label.getLabel());
			
			CriarJogador jogador = new CriarJogador(nomeusuario, pontos);
			jogador.salvarJogador();
		}
		
		
}
