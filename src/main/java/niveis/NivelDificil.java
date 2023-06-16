package niveis;

import java.util.Random;

import contas.Conta;
import contas.Dividir;
import contas.Multiplicar;
import contas.Soma;
import contas.Subtrair;

public class NivelDificil implements NivelDificuldade {

	Conta conta;
	Random gerador = new Random();
	int num1, num2;

	public NivelDificil() {

	}

	public Conta geraPergunta() {
		num1 = gerador.nextInt(20) + 1;
		num2 = gerador.nextInt(20) + 1;
		int tipoDeConta = gerador.nextInt(4); // num aleatorio pra gerar o tipo de conta

		// padrao strategy
		if (tipoDeConta == 0) {
			return conta = new Soma(num1, num2);
		} else if (tipoDeConta == 1) {
			return conta = new Subtrair(num1, num2);
		} else if (tipoDeConta == 2)
			return conta = new Dividir(num1, num2);
		else if (tipoDeConta == 3)
			return conta = new Multiplicar(num1, num2);
		else
			return null;
	}

	public float Resultado() {
		return conta.getResult();
	}

	public String pergunta() {
		return conta.conta(num1, num2);
	}

	public String ResultadoTexto() {
		return conta.resultadoFormat();
	}

}
