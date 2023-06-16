package niveis;

import contas.Conta;

public interface NivelDificuldade {
		
	public Conta geraPergunta();
	public float Resultado();
	public String pergunta();
	public String ResultadoTexto();

}
