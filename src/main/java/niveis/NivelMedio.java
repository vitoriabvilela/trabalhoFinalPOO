package niveis;

import java.util.Random;

import contas.Conta;
import contas.Dividir;
import contas.Multiplicar;
import contas.Soma;
import contas.Subtrair;

public class NivelMedio implements NivelDificuldade {

	Conta conta;
	Random gerador = new Random();
	int num1, num2;

	public NivelMedio() {

	}

	public Conta geraPergunta() {
		num1 = gerador.nextInt(10) + 1;
		num2 = gerador.nextInt(10) + 1;
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
		return this.conta.getResult();
	}

	public String pergunta() {
		return this.conta.conta(num1, num2);
	}

	public String ResultadoTexto() {
		return this.conta.resultadoFormat();
	}

}
