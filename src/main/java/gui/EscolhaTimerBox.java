package gui;

public class EscolhaTimerBox {

	private int valor;
	private String descricao;

	public EscolhaTimerBox(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
