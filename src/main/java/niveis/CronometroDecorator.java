package niveis;

import java.util.Timer;
import java.util.TimerTask;

import contas.Conta;

public class CronometroDecorator implements NivelDificuldade {

	Conta conta;
	NivelDificuldade pergunta;
	Timer timer;
	Timer timer2;
	// int num1, num2;

	final long segundos = (1000 * 10); // de 10 em 10 segundos

	public CronometroDecorator(NivelDificuldade pergunta) {
		this.pergunta = pergunta;
	}

	public Conta geraPergunta() {
		conta = pergunta.geraPergunta();
		return conta;
	}

	public float Resultado() {
		return conta.getResult();
	}

	public String pergunta() {
		return pergunta.pergunta();
	}

	public String ResultadoTexto() {
		return pergunta.ResultadoTexto();

	}

	public void iniciarCronometro() {
		if (timer == null) {

			timer = new Timer();

			TimerTask tarefa = new TimerTask() {
				public void run() {
					conta = geraPergunta();
					pergunta();
					Resultado();
					ResultadoTexto();
				}
			};

			timer.scheduleAtFixedRate(tarefa, 10000, segundos);

		}
	}

	public int pararCronometro() {
		if (timer != null) {
			timer.cancel();
			timer = null;
			return 1;
		} else
			return 0;
	}

}
