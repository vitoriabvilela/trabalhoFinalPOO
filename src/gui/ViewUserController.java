package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewUserController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField txtUser;

	@FXML
	private Button btIniciar;
		
	public void onIniciarButton(ActionEvent event) throws IOException {
		
		String username = txtUser.getText();
		
		FXMLLoader login = new FXMLLoader(getClass().getResource("View.fxml"));
		root = login.load();
		
		ViewController viewcontroller = login.getController();
		viewcontroller.bemVindo(username);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
