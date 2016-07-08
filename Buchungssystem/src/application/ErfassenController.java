package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Budget;

public class ErfassenController {
	
	@FXML
	private TextField tfWert;
	@FXML
	private DatePicker dpStartDate;
	@FXML
	private Label lbOperation;
	@FXML
	private DatePicker dpEndDate;
	@FXML
	private CheckBox cbDauerauftrag;
	@FXML
	private ComboBox<String> cmbZyklus = new ComboBox<String>();
	@FXML
	private Budget budget;
	
	@FXML
	public void erfassen() {
		
		if(cbDauerauftrag.isSelected()) {
			budget = new Budget(Double.parseDouble(tfWert.getText()), dpStartDate.getValue(), lbOperation.getText(),
								dpEndDate.getValue(), cbDauerauftrag.isSelected(), cmbZyklus.getValue());
		} else {
			budget = new Budget(Double.parseDouble(tfWert.getText()), dpStartDate.getValue(), lbOperation.getText());
		}
		
		
		System.out.println("Budget    \t " + budget.getWert());
		System.out.println("Operation \t " + budget.getOperation());
		System.out.println("Zyklus    \t " + budget.getZyklus());
		System.out.println("Enddate   \t " + budget.getEndDate());
		System.out.println("Startdate \t " + budget.getStartDate());
		
		// Datenbankaufruf oder Hashmap anpassen
		
	}
	
	@FXML
	protected void initialize() {	
		initZyklus();
	}
	
	private void initZyklus() {
		//Datenbankaufruf mit dem 
		String sql = "Select TAGE From Zyklus";

		cmbZyklus.getItems().add("1 täglich");
		cmbZyklus.getItems().add("5 täglich");
		cmbZyklus.getItems().add("7 täglich");
		cmbZyklus.getItems().add("14 täglich");
		cmbZyklus.getItems().add("1 monatlich");
		cmbZyklus.getItems().add("6 monatlich");
		
		cmbZyklus.setValue("1 monatlich");
	}

	public TextField getTfWert() {
		return tfWert;
	}

	public void setTfWert(TextField tfWert) {
		this.tfWert = tfWert;
	}

	public DatePicker getDpStartDate() {
		return dpStartDate;
	}

	public void setDpStartDate(DatePicker dpStartDate) {
		this.dpStartDate = dpStartDate;
	}

	public Label getLbOperation() {
		return lbOperation;
	}

	public void setLbOperation(Label lbOperation) {
		this.lbOperation = lbOperation;
	}

	public DatePicker getDpEndDate() {
		return dpEndDate;
	}

	public void setDpEndDate(DatePicker dpEndDate) {
		this.dpEndDate = dpEndDate;
	}

	public CheckBox getCbDauerauftrag() {
		return cbDauerauftrag;
	}

	public void setCbDauerauftrag(CheckBox cbDauerauftrag) {
		this.cbDauerauftrag = cbDauerauftrag;
	}

	public ComboBox<String> getCmbZyklus() {
		return cmbZyklus;
	}

	public void setCmbZyklus(ComboBox<String> cmbZyklus) {
		this.cmbZyklus = cmbZyklus;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
