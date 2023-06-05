package gui;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	Random gerador = new Random();
	float userAnswer, result, num1, num2;        
	int pontos = 0;                             //configurar uma classe pra guardar pontos
	int tipoDeConta;
	Conta conta;
	
	@FXML
	private TextField txtResult;
	
	@FXML
	private Button btSum;
	
	@FXML
	private Button btCalcule;
	
	@FXML
	Label questionLabel = new Label();
	
	@FXML 
	Label labelResult = new Label();
	
	@FXML
	Label labelNome = new Label();
	
	@FXML
	Label labelPontos = new Label();
			
	@FXML
	public void gerarPergunta() {
		
		num1 = gerador.nextInt(11) + 1;
		num2 = gerador.nextInt(11) + 1;
		tipoDeConta = gerador.nextInt(4); //num aleatorio pra gerar o tipo de conta 
		
		//padrao strategy
		if(tipoDeConta == 0) {
			conta = new Soma();
		}
		
		else if(tipoDeConta == 1) {
			conta = new Dividir();
		}
		
		else if(tipoDeConta == 2) {
			conta = new Subtrair();
		}
		
		else if(tipoDeConta == 3) {
			conta = new Multiplicar();
		}
		
		result = conta.getResult();
				
		questionLabel.setText(conta.conta(num1, num2)); // Define a pergunta na interface

	}
	
	public void bemVindo(String username) {
		labelNome.setText(username + ", calcule:");
		gerarPergunta();
	}
	
	@FXML
	public void onBtContinuar() {
		gerarPergunta();
		labelResult.setText(""); //esvazia campo de resultado
		txtResult.clear();
	}
	
	
	public void verificaResposta(){
        userAnswer = Float.parseFloat(txtResult.getText());    

		if (userAnswer == conta.getResult()) {
    		labelResult.setText("Resposta correta!");
    		pontos = pontos + 1;                        // verificar isso aqui
    		
        } else if (userAnswer != conta.getResult()){
    		labelResult.setText("Resposta incorreta! A resposta correta é: " + conta.resultadoFormat());
        }
	}
	
	
		
}
