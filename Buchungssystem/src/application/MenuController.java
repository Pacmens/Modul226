package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {
	private static boolean _logout = false;
	
	@FXML
	public void profilDatenAendern() throws IOException {
		newStage("ProfilChangeSeite.fxml");
	}
	
	@FXML 
	public void abmelden() throws IOException {
		setLogout(true);
		changeScene("Loginseite.fxml", getClass());
	}
	
	@FXML
	public void budgetAnsehen() throws IOException {
		changeScene("HomeSeite.fxml", getClass());
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
		if (_logout && fxml != "Loginseite.fxml") {
			_logout = false;
		}
	}

	public static boolean isLogout() {
		return _logout;
	}

	public static void setLogout(boolean logout) {
		_logout = logout;
	}
	
	public void newStage(String fxml) throws IOException {
		Stage stage = new Stage();
		stage.initOwner(Main.getPrimaryStage());
		stage.initModality(Modality.WINDOW_MODAL);
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
