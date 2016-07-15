package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Person;

public class PersonAendernController extends MenuController{

	

		
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
		private Label lbAendernErfolg;

		//TODO fehler handlen
		@FXML
		public void aendern() throws SQLException {
			String sql = "Select EMAIL From PERSON";
			ResultSet email = DatabaseManager.getDatabaseManager().sendQuery(sql);
			if (email.getFetchSize() > 0) return;
			if(pfPassword.getText().equals(pfPasswordRepeat.getText())) {
				Person person = new Person(tfName.getText(), tfEmail.getText(), pfPassword.getText());
				String registerSql = "Update PERSON set NAME = '" + person.getName() + "', EMAIL='" + person.getEmail() + "', PASSWORT='" + person.getPassword() + "' WHERE PERSON_ID = '" + LoginController.getPerson().getPersonId() + "';";
				DatabaseManager.getDatabaseManager().sendUpdate(registerSql);
				try {
					LoginController.reloadUser();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lbAendernErfolg.setText("Sie haben Ihre Kontodaten erfolgreich verändert");
				lbFehlermeldung.setText("");
			} else {
				lbAendernErfolg.setText("");
				lbFehlermeldung.setText("Die beiden Passwörter sind nicht gleich");
			}
		}
		
		@FXML
		protected void initialize() {
			Person person = LoginController.getPerson();
			if (person != null) {
				tfName.setText(person.getName());
				tfEmail.setText(person.getEmail());
				pfPassword.setText(person.getPassword());
				pfPasswordRepeat.setText(person.getPassword());
			}
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
