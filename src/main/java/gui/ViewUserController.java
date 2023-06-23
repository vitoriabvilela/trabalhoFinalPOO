package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewUserController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TextField txtUser;

	@FXML
	private Button btIniciar;
	
	@FXML 
	ComboBox<EscolhaTimerBox> caixaCronometro;
	
	@FXML
	ComboBox<NivelComboBox> caixaNivel;
 
	ObservableList<NivelComboBox> numbers;
	ObservableList<EscolhaTimerBox> escolhaCronometro;


	public void initialize(URL url, ResourceBundle rb) {
		carregarNiveis();
		carregarEscolhaCronometro();
	}
	
	//cadastro de opções que aparecem no ComboBox para usuario selecionar o nível desejado
	public void carregarNiveis() {		
		List<NivelComboBox> list = new ArrayList<>();
		
	    list.add(new NivelComboBox(1, "Nível 1 - Fácil"));
	    list.add(new NivelComboBox(2, "Nível 2 - Médio"));
	    list.add(new NivelComboBox(3, "Nível 3 - Difícil"));

	    numbers = FXCollections.observableArrayList(list);
	    caixaNivel.setItems(numbers);
	}
	
	public void carregarEscolhaCronometro(){
		
		List<EscolhaTimerBox> list2 = new ArrayList<>();
		
		list2.add(new EscolhaTimerBox(1, "Sim, quero cronômetro."));
		list2.add(new EscolhaTimerBox(0, "Não quero cronômetro."));
		
		escolhaCronometro = FXCollections.observableArrayList(list2);
		caixaCronometro.setItems(escolhaCronometro);
	}	
	
	
	//só permitir iniciar o jogo se o jogador digitar o nome e selecionar o nivel
	public void onKeyReleasead() {
		
		boolean nomeVazio = txtUser.getText().isEmpty();
		boolean nivelVazio = caixaNivel.getSelectionModel().isEmpty();
		boolean cronometroVazio = caixaCronometro.getSelectionModel().isEmpty();
		
		//se o campo de nome ou nivel estiver vazio o botão iniciar fica desabilitado
		if (nomeVazio || nivelVazio || cronometroVazio) {
			btIniciar.setDisable(true);
		}
		else btIniciar.setDisable(false);
	}
	
	
	@FXML
	public void onIniciarButton(ActionEvent event) throws IOException {

		String username = txtUser.getText();
		int selectedNumber = caixaNivel.getSelectionModel().getSelectedItem().getValor();
		int escolhaCronometro = caixaCronometro.getSelectionModel().getSelectedItem().getValor();
		
		//vai para segunda tela do jogo View
		FXMLLoader login = new FXMLLoader(getClass().getResource("View.fxml")); 
		root = login.load();
		
		
		ViewController viewcontroller = login.getController();
		viewcontroller.bemVindo(username, selectedNumber, escolhaCronometro);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
