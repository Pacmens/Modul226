package application;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import entities.Budget;
import entities.BudgetWithTyp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mapper.DatabaseMapper;

public class HomeController extends MenuController {
	
	@FXML
	private Label lbWelcomeText;
	@FXML
	private Label lbKontostand;
	private Double budget;
	private List<BudgetWithTyp> budgetTp;

		@FXML
	    public void initialize() {      
		System.out.println("asdfdasfaew");
		String sql = "Select * From (Select * From Budget Inner Join Typ On Budget.Typ_Id_Fs = Typ.Typ_Id) as BudgetUndTyp WHERE PERSON_ID = '" + LoginController.getPerson().getPersonId() + "'";
		budgetTp = new ArrayList<>();
		try {
			budgetTp = new ArrayList<>(DatabaseMapper.getObjectOfResutSet(System.getProperty("user.dir") + "/src/mapping/mapBudgetWithTyp.standartmapBudgetWithTyp", DatabaseManager.getDatabaseManager().sendQuery(sql)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Main.getBudgetList() = SQL-Output
		calculateBudget();
		lbKontostand.setText(budget.toString());
		lbWelcomeText.setText("Wilkommen " + LoginController.getPerson().getName() + ", Sie sind eingeloggt.");
	}

	private void  calculateBudget() {
		Double budgetTmp = 0.0;
		for (BudgetWithTyp b:budgetTp) {
			budgetTmp = budgetTmp + b.getMenge() * b.getMultiplikator();
		}
		budget = budgetTmp;
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
