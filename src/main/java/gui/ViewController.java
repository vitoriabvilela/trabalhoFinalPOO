package gui;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
import niveis.CronometroDecorator;
import niveis.GerarNivelDificuldade;
import niveis.NivelDificuldade;
import javafx.application.Platform;

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
	private CronometroDecorator decorator;
	private int escolhaTimer;

	Timer timer;
	final long segundos = (1000 * 10); // de 5 em 5 segundos

	public ViewController() {

	}

	@FXML
	private TextField txtResult;

	@FXML
	private Button btSum;

	@FXML
	private Button btContinuar;

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

	public void bemVindo(String username, int numeroSelecionado, int escolhaTimer) {
		labelNome.setText(username + ", calcule:");
		nomeusuario = username; // pegou nome do jogador
		nivelEscolhido = numeroSelecionado; // pegou nivel que jogador selecionou
		this.escolhaTimer = escolhaTimer;
		gerarPergunta();
	}

	public void gerarPergunta() {

		if (escolhaTimer == 1) {

			GerarNivelDificuldade gerarNivel = new GerarNivelDificuldade(nivelEscolhido);
			nivelDificuldade = gerarNivel.gerar();

			decorator = new CronometroDecorator(nivelDificuldade);
			
			//vai gerar uma pergunta normal e pegar o resultado da primeira pergunta
			decorator.geraPergunta();
			result = decorator.Resultado();
			
			//iniciou timer para gerar outra pergunta em 10 segundos 
			decorator.iniciarCronometro();
			
			//iniciou timer para pegar a questão nova de 10 em 10s imediatamente
			//e o resultado será atualizado de 10 em 10s dps de 10s que iniciou
			iniciarTimer();

			btSum.setDisable(false);
		}

		else if (escolhaTimer == 0) {

			GerarNivelDificuldade gerarNivel = new GerarNivelDificuldade(nivelEscolhido);
			nivelDificuldade = gerarNivel.gerar();
			
			nivelDificuldade.geraPergunta(); // gera pergunta a partir do nivel selecionado
			result = nivelDificuldade.Resultado(); // pegou o resultado correto da conta

			questionLabel.setText(nivelDificuldade.pergunta()); // Define a pergunta na interface
			btSum.setDisable(false); // habilitou o botão responder
		}

	}

	public void iniciarTimer() {
		if (timer == null) {
			timer = new Timer();

			TimerTask perguntaTxt = new TimerTask() {
				public void run() {
					Platform.runLater(() -> questionLabel.setText(decorator.pergunta()));
				}
			};

			TimerTask resultado = new TimerTask() {
				public void run() {
					result = decorator.Resultado();
				}
			};

			timer.scheduleAtFixedRate(perguntaTxt, 0, segundos);
			timer.scheduleAtFixedRate(resultado, 10000, segundos);
		}
	}

	public int pararTimer() {
		if (timer != null) {
			timer.cancel();
			timer = null;
			return 1;
		}
		return 0;
	}

	@FXML
	public void onBtContinuar() {

		gerarPergunta();

		labelResult.setText(""); // esvazia campo de resultado
		txtResult.clear();
		btContinuar.setDisable(true);
	}

	public void onBtResponder() {
		
		//só terá timer se o usuário optou por ter, então só vamos parar se existir a instência decorator
		if(escolhaTimer == 1) {
			decorator.pararCronometro();
			pararTimer();
		}

		// pegou a resposta do jogador
		userAnswer = Float.parseFloat(txtResult.getText());

		VerificaResposta verificaResposta = new VerificaResposta(userAnswer, result);
		int x = verificaResposta.verificar();

		if (x == 1) { // se a resposta for correta o verificaRespota retorna x = 1
			labelResult.setText("Resposta correta!");

			pontuacao = pontos.pontua(); // passa os pontos para um int pontuacao
			exibirPontos = String.valueOf(pontuacao);

			labelPontos.setText(exibirPontos);

		} else if (x == 0) {
			labelResult.setText("Resposta incorreta! A resposta correta é: " + nivelDificuldade.ResultadoTexto());
		}

		questionLabel.setText(""); // retira a pergunta depois do jogador clicar em responder
		txtResult.setText(""); // depois que o usuario responder esvazia a resposta dele

		btSum.setDisable(true);
		btContinuar.setDisable(false);
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
