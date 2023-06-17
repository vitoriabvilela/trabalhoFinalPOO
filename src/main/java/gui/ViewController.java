package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jogador.Pontuacao;
import niveis.GerarNivelDificuldade;
import niveis.NivelDificuldade;

public class ViewController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	private int nivelEscolhido;
	private NivelDificuldade nivelDificuldade;
	private float userAnswer, result;
	private String nomeusuario;
	private Pontuacao pontos = new Pontuacao();
	private int pontuacao = 0;
	private String exibirPontos;

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

	public void bemVindo(String username, int numeroSelecionado) {
		labelNome.setText(username + ", calcule:");
		nomeusuario = username;             // pegou nome do jogador
		nivelEscolhido = numeroSelecionado; // pegou nivel que jogador selecionou
		gerarPergunta();

	}

	public void gerarPergunta() {

		GerarNivelDificuldade gerarNivel = new GerarNivelDificuldade(nivelEscolhido);
		nivelDificuldade = gerarNivel.gerar();

		nivelDificuldade.geraPergunta();       // gera pergunta a partir do nivel selecionado
		result = nivelDificuldade.Resultado(); //pegou o resultado correto da conta

		questionLabel.setText(nivelDificuldade.pergunta()); // Define a pergunta na interface
	}

	@FXML
	public void onBtContinuar() {
		gerarPergunta();
		labelResult.setText(""); // esvazia campo de resultado
		txtResult.clear();
	}

	// chamado depois de pressionar botão Responder

	public void verificaResposta() {

		userAnswer = Float.parseFloat(txtResult.getText());

		VerificaResposta verificaResposta = new VerificaResposta(userAnswer, result);
		int x = verificaResposta.verificar();

		if (x == 1) { // se a resposta for correta o verificaRespota retorna x = 1
			labelResult.setText("Resposta correta!");
					
			pontuacao = pontos.pontua(); //passa os pontos para um int pontuacao
			exibirPontos =  String.valueOf(pontuacao);
			
			labelPontos.setText(exibirPontos);
			
		} else if (x == 0) {
			labelResult.setText("Resposta incorreta! A resposta correta é: " + nivelDificuldade.ResultadoTexto());
		}
	}

	@FXML
	public void onBtFinalizar(ActionEvent event) throws IOException {

		FXMLLoader login = new FXMLLoader(getClass().getResource("ViewFinal.fxml"));
		root = login.load();

		ViewResultado viewresultado = login.getController();

		// passando para a última tela com resultado
		viewresultado.setResultado(nomeusuario, pontos.getPontos());

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
