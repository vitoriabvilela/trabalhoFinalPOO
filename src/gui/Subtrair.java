package gui;

public class Subtrair implements Conta{
	
	private float result;

	public String conta(float x, float y) {
		this.result = x - y;
		return String.format("%.0f", x) + 
				" - " 
				+ String.format("%.0f", y) 
				+ " = ?";		}
	
	public float getResult() {
		return this.result;
	}

	public String resultadoFormat() {
		return String.format("%.0f", this.result);
	}

}
