package application;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import database.DatabaseManager;
import entities.BudgetWithTyp;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import mapper.DatabaseMapper;

public class BudgetverlaufController extends MenuController {

	@FXML
	TableColumn<BudgetWithTyp, String> tblClnDatum;
	@FXML
	TableColumn<BudgetWithTyp, String> tblClmVeraenderung;
	@FXML
	TableColumn<BudgetWithTyp, String> tblClnTyp;
	@FXML
	TableView<BudgetWithTyp> tblBudgetTable;
	@FXML
	Label lbMomentanerKontostand;

	@FXML
	public void initialize() {
		String sql = "Select * From (Select * From Budget Inner Join Typ On Budget.Typ_Id_Fs = Typ.Typ_Id) as BudgetUndTyp WHERE PERSON_ID_FS = '"
				+ LoginController.getPerson().getPersonId() + "' AND DATUM <= CURDATE()";
		ArrayList<BudgetWithTyp> budgetTp = new ArrayList<>();
		try {
			budgetTp = new ArrayList<>(DatabaseMapper.getObjectOfResutSet(
					System.getProperty("user.dir") + "/src/mapping/mapBudgetWithTyp.standartmapBudgetWithTyp",
					DatabaseManager.getDatabaseManager().sendQuery(sql)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(budgetTp, new Comparator<BudgetWithTyp>() {
			@Override
			public int compare(BudgetWithTyp o1, BudgetWithTyp o2) {
				return o1.getDatum().compareTo(o2.getDatum());
				
			}
		});
		tblBudgetTable.getItems().addAll(budgetTp);
		tblClnTyp.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<BudgetWithTyp, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<BudgetWithTyp, String> param) {
						BudgetWithTyp value = param.getValue();
						return new ReadOnlyObjectWrapper<String>(value.getName());
					}
				});
		tblClmVeraenderung.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<BudgetWithTyp, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<BudgetWithTyp, String> param) {
						BudgetWithTyp value = param.getValue();
						Double aenderung = value.getMenge() * value.getMultiplikator();
						return new ReadOnlyObjectWrapper<String>(aenderung + " CHF");
					}
				});
		tblClnDatum.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<BudgetWithTyp, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<BudgetWithTyp, String> param) {
						BudgetWithTyp value = param.getValue();
						
						return new ReadOnlyObjectWrapper<String>(value.getDatum().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
					}
				});
		Double budgetTmp = 0.0;
		for (BudgetWithTyp b : budgetTp) {
			if (b.getDatum().compareTo(Date.valueOf(LocalDate.now())) <= 0) {
				budgetTmp = budgetTmp + b.getMenge() * b.getMultiplikator();
			}
		}
		lbMomentanerKontostand.setText(budgetTmp + " CHF");

	}

}
