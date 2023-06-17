package contas;

public class Dividir implements Conta{
	
	private float result;
	float num1, num2;
	
	public Dividir(float num1, float num2) {
		result = (num1/num2);
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String conta(float x, float y) {
		return String.format("%.0f", x) + 
				"/" 
				+ String.format("%.0f", y) 
				+ " = ?";	}
	
	public float getResult() {
		return this.result;
	}
	
	public String resultadoFormat() {
		return String.format("%.2f", this.result);
	}
	
	public float getNum1() {
		return num1;
	}
	
	public float getNum2() {
		return num2;
	}

}
