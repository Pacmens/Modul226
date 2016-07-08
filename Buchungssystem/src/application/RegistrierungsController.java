package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Person;

public class RegistrierungsController {
	
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfEmail;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private PasswordField pfPasswordRepeat;
	@FXML
	private Label lbFehlermeldung;
	@FXML
	private Label lbRegistrierungErfolg;

	//TODO fehler handlen
	@FXML
	public void registrieren() throws SQLException {
		String sql = "Select EMAIL From PERSON";
		ResultSet email = DatabaseManager.getDatabaseManager().sendQuery(sql);
		if (email.getFetchSize() > 0) return;
		if(pfPassword.getText().equals(pfPasswordRepeat.getText())) {
			Person person = new Person(tfName.getText(), tfEmail.getText(), pfPassword.getText());
			System.out.println("Name\t" + person.getName());
			System.out.println("Email\t" + person.getEmail());
			System.out.println("Password\t" + person.getPassword());
			lbRegistrierungErfolg.setText("Sie haben sich erfolgreich Registriert");
			lbFehlermeldung.setText("");
		} else {
			lbRegistrierungErfolg.setText("");
			lbFehlermeldung.setText("Die beiden Passwörter sind nicht gleich");
		}
	}
	
	@FXML
	protected void initialize() {	
	}

	public TextField getTfName() {
		return tfName;
	}
	public void setTfName(TextField tfName) {
		this.tfName = tfName;
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

	public PasswordField getPfPasswordRepeat() {
		return pfPasswordRepeat;
	}
	public void setPfPasswordRepeat(PasswordField pfPasswordRepeat) {
		this.pfPasswordRepeat = pfPasswordRepeat;
	}

	public Label getLbFehlermeldung() {
		return lbFehlermeldung;
	}
	public void setLbFehlermeldung(Label lbFehlermeldung) {
		this.lbFehlermeldung = lbFehlermeldung;
	}
}
