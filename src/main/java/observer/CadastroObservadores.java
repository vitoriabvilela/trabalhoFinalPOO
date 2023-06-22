package observer;

import jogador.Pontuacao;

public class CadastroObservadores {

	int pontos;

	// cadastro observer
	RecordePontuacao recorde = new RecordePontuacao();

	// observadores
	Pontuacao observador = new Pontuacao();
	LabelRecorde label = new LabelRecorde();

	public CadastroObservadores(int pontos) {
		this.pontos = pontos;
		registro();
	}

	public void registro() {
		// registrei os observadores
		recorde.registraObserver(observador);
		recorde.registraObserver(label);
		
		//atualizei a nova pontuacao
		recorde.atualizarPontuacao(pontos);
	}

	// se houve recorde de pontuacao, o observer avisa os observadores
	// no notify do observador label ele altera uma String que é inicialmente vazia
	// para um texto avisando que o recorde foi batido
	// logo, se o recorde não foi batido o código abaixo retorna apenas uma string vazia

	public String getTextLabel() {
		return label.getLabel();
	}

}
