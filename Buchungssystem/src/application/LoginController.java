package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import database.DatabaseManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mapper.DatabaseMapper;
import models.Person;

public class LoginController {
	
	@FXML
	private TextField tfEmail;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Label lbFehlermeldung;
	private static Person _person;
	

	@FXML
	public void login() throws Exception{
		String sql = "Select * From Person Where EMAIL = '" + tfEmail.getText() + "' AND " + " PASSWORT = '" + pfPassword.getText() + "'";
		
		ResultSet sendQuery = DatabaseManager.getDatabaseManager().sendQuery(sql);
		List<Person> person = DatabaseMapper.getObjectOfResutSet("src/mappings/person.person", sendQuery);
		//wenn SQLCode = 0 ist dann ist anmelden erfolgreich
		if (person.size() != 1) {throw new Exception("Wrong Login");}
		System.out.println(sql);
		_person = person.get(0);
		changeScene("Homeseite.fxml");
	}
	
	@FXML
	public void registrieren() throws Exception{
		newStage("Registrierungsseite.fxml");
	}
	
	private void changeScene(String fxml) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.getPrimaryStage().setScene(scene);
	}
	
	private void newStage(String fxml) throws IOException {
		Stage stage = new Stage();
		stage.initOwner(Main.getPrimaryStage());
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public TextField getTfEmail() {
		return tfEmail;
	}
	public void setTfEmail(TextField tfEmail) {
		this.tfEmail = tfEmail;
	}
	
	public PasswordField getPfPassword() {
		return pfPassword;
	}
	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}
	
	public Label getLbFehlermeldung() {
		return lbFehlermeldung;
	}
	public void setLbFehlermeldung(Label lbFehlermeldung) {
		this.lbFehlermeldung = lbFehlermeldung;
	}

	public static Person getPerson() {
		return _person;
	}
}
