package application;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import database.DatabaseManager;
import entities.BudgetWithTyp;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import mapper.DatabaseMapper;

public class BudgetAnsehenController extends MenuController {

	@FXML Label lbMoentanerKontostand;
	@FXML NumberAxis axsMoney;
	@FXML CategoryAxis axsTime;
	@FXML LineChart<Double, Date> crtLineChart;
	
	
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
		
		Iterator<BudgetWithTyp> dates = budgetTp.iterator();
		while (dates.hasNext()) {
			dates.next();
		}
		
		Collections.sort(budgetTp, new Comparator<BudgetWithTyp>() {
			@Override
			public int compare(BudgetWithTyp o1, BudgetWithTyp o2) {
				return o1.getDatum().compareTo(o2.getDatum());
				
			}
		});
		
		Double budgetTmp = 0.0;
		for (BudgetWithTyp b : budgetTp) {
			if (b.getDatum().compareTo(Date.valueOf(LocalDate.now())) <= 0) {
				budgetTmp = budgetTmp + b.getMenge() * b.getMultiplikator();
			}
		}
		lbMoentanerKontostand.setText(budgetTmp + " CHF");

	}
	
}
