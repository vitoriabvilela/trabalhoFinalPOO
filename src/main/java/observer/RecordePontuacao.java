package observer;

import java.util.ArrayList;
import java.util.List;

import jogador.GamerDAO;

public class RecordePontuacao implements Subject {
	
	GamerDAO gamer = new GamerDAO();
	
	//peguei do banco qual a maior pontuacao
	int maiorPontuacao = gamer.obterMaiorPontuacao();
	
	private List<Observer> observers = new ArrayList<>();

	public void atualizarPontuacao(int novaPontuacao) {
        if (novaPontuacao > maiorPontuacao) {
            notifyObservers(novaPontuacao);
        }
    }
	
	@Override
	public void registraObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers(int novoRecorde) {
		observers.forEach(o -> o.notify(novoRecorde));
	}

}
