package niveis;

import java.util.Random;

import contas.Conta;
import contas.Soma;
import contas.Subtrair;

public class NivelFacil implements NivelDificuldade {

	Conta conta;
	Random gerador = new Random();
	float num1, num2;

	public NivelFacil() {

	}
	
	//nivel facil tem apenas numeros de 1 ao 5 e soma e subtracao 
	
	public Conta geraPergunta() {
		num1 = gerador.nextInt(5) + 1;
		num2 = gerador.nextInt(5) + 1;
		int tipoDeConta = gerador.nextInt(2); // num aleatorio pra gerar o tipo de conta

		// padrao strategy
		if (tipoDeConta == 0) {
			return conta = new Soma(num1, num2);
		}

		else if (tipoDeConta == 1) {
			return conta = new Subtrair(num1, num2);
		} else
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
