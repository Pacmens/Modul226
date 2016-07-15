package application;

import database.DatabaseManager;
import entities.Budget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mapper.DatabaseMapper;

public class HomeController {

	@FXML
	private Label lbWelcomeText;
	@FXML
	private Label lbKontostand;
	private Double budget;

	@FXML
	protected void initialize() throws Exception {
		String sql = "Select * From BUDGET WHERE PERSON_ID = '" + Main.getPersonId() + "'";
		Budget budget = (Budget) DatabaseMapper.getObjectOfResutSet("/mapping/mapBudget.standartmapBudget", DatabaseManager.getDatabaseManager().sendQuery(sql));

		// Main.getBudgetList() = SQL-Output
		calculateBudget();
		lbKontostand.setText(budget.toString());
		lbWelcomeText.setText("Wilkommen " + Main.getName() + ", Sie sind eingeloggt.");
	}

	private void  calculateBudget() {
		budget = 0.0;
	}

	public Label getLbWelcomeText() {
		return lbWelcomeText;
	}
	public void setLbWelcomeText(Label lbWelcomeText) {
		this.lbWelcomeText = lbWelcomeText;
	}

	public Label getLbKontostand() {
		return lbKontostand;
	}
	public void setLbKontostand(Label lbKontostand) {
		this.lbKontostand = lbKontostand;
	}
}
