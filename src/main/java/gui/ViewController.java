package gui;

import java.io.IOException;
import java.util.Random;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController {

	Random gerador = new Random();
	float userAnswer, result, num1, num2;
	int pontos = 0; // configurar uma classe pra guardar pontos
	int tipoDeConta;
	Conta conta;
	String nomeusuario;
	private Stage stage;
	private Scene scene;
	private Parent root;

	public ViewController() {

	}

	@FXML
	private TextField txtResult;

	@FXML
	private Button btSum;

	@FXML
	private Button btCalcule;

	@FXML
	private Button btFinalizar;

	@FXML
	Label questionLabel = new Label();

	@FXML
	Label labelResult = new Label();

	@FXML
	Label labelNome = new Label();

	@FXML
	Label labelPontos = new Label();

	public void bemVindo(String username) {
		labelNome.setText(username + ", calcule:");
		gerarPergunta();
		nomeusuario = username;
	}
	
	@FXML
	public void gerarPergunta() {

		num1 = gerador.nextInt(10) + 1;
		num2 = gerador.nextInt(10) + 1;
		tipoDeConta = gerador.nextInt(4); // num aleatorio pra gerar o tipo de conta

		// padrao strategy
		if (tipoDeConta == 0) {
			conta = new Soma();
		}

		else if (tipoDeConta == 1) {
			conta = new Dividir();
		}

		else if (tipoDeConta == 2) {
			conta = new Subtrair();
		}

		else if (tipoDeConta == 3) {
			conta = new Multiplicar();
		}

		result = conta.getResult();

		questionLabel.setText(conta.conta(num1, num2)); // Define a pergunta na interface
	}

	@FXML
	public void onBtContinuar() {
		gerarPergunta();
		labelResult.setText(""); // esvazia campo de resultado
		txtResult.clear();
	}
	
	//chamado depois de pressionar botão Responder
	
	public void verificaResposta() {
		userAnswer = Float.parseFloat(txtResult.getText());

		if (userAnswer == conta.getResult()) {
			labelResult.setText("Resposta correta!");
			pontos = pontos + 1; // verificar isso aqui

		} else if (userAnswer != conta.getResult()) {
			labelResult.setText("Resposta incorreta! A resposta correta é: " + conta.resultadoFormat());
		}
	}	

	public void onBtFinalizar(ActionEvent event) throws IOException {

		FXMLLoader login = new FXMLLoader(getClass().getResource("ViewFinal.fxml"));
		root = login.load();

		ViewResultado viewresultado = login.getController();
		viewresultado.setResultado(nomeusuario, pontos); //passando para a última tela com resultado
				
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

}
