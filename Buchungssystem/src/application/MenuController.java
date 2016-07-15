package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MenuController {
	@FXML
	public void profilDatenAendern() {
		
	}
	
	@FXML 
	public void abmelden() {
		
	}
	
	@FXML
	public void budgetAnsehen() {
		
	}
	
	@FXML 
	public void budgetVerlauf() {
		
	}
	
	@FXML
	public void budgetErfassen() throws IOException {
		changeScene("ErfassenSeite.fxml", getClass());
	}
	
	public void changeScene(String fxml, Class clazz) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(clazz.getResource(fxml));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(clazz.getResource("application.css").toExternalForm());
		Main.getPrimaryStage().setScene(scene);
	}
}
