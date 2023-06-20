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

	ObservableList<Integer> numbers;

	@FXML
	ComboBox<Integer> caixaNivel;

	public void initialize(URL url, ResourceBundle rb) {
		carregarNiveis();
	}

	public void carregarNiveis() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		numbers = FXCollections.observableArrayList(list);
		caixaNivel.setItems(numbers);
	}
	
	//só permitir iniciar o jogo se o jogador digitar o nome e selecionar o nivel
	public void onKeyReleasead() {
		
		boolean nomeVazio = txtUser.getText().isEmpty();
		boolean nivelVazio = caixaNivel.getSelectionModel().isEmpty();
		
		if (nomeVazio || nivelVazio) {
			btIniciar.setDisable(true);
		}
		else btIniciar.setDisable(false);
	}
	
	
	@FXML
	public void onIniciarButton(ActionEvent event) throws IOException {

		String username = txtUser.getText();
		int selectedNumber = caixaNivel.getSelectionModel().getSelectedItem();
		
		//vai para segunda tela do jogo View
		FXMLLoader login = new FXMLLoader(getClass().getResource("View.fxml")); 
		root = login.load();
		
		
		ViewController viewcontroller = login.getController();
		viewcontroller.bemVindo(username, selectedNumber);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
