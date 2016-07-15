package application;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import entities.Budget;
import entities.Typ;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import mapper.DatabaseMapper;

public class ErfassenController extends MenuController {
	
	@FXML
	private TextField tfWert;
	
	@FXML
	private DatePicker dpStartDate;
	
	@FXML
	private ComboBox<Typ> cbTyp;
	
	private Budget budget;
	
	@FXML
	public void erfassen() {
			budget = new Budget();
			budget.setTypIdFs(cbTyp.getSelectionModel().getSelectedItem().getTypId());
			budget.setDatum(Date.valueOf(dpStartDate.getValue()));
			budget.setMenge(new Double(tfWert.getText()));
			
		// Datenbankaufruf oder Hashmap anpassen
			String sql = "Insert into budget (PERSON_ID_FS, MENGE, DATUM, TYP_ID_FS) VALUES ('" + LoginController.getPerson().getPersonId() + "', '" + budget.getMenge() + "', '" + budget.getDatum() + "', '" + budget.getTypIdFs() + "');";
			DatabaseManager.getDatabaseManager().sendUpdate(sql);
	}
	
	@FXML
	protected void initialize() {	
		initZyklus();
	}
	
	private void initZyklus() {
		//Datenbankaufruf mit dem 
		String sql = "Select * From Typ";
		ResultSet sendQuery = DatabaseManager.getDatabaseManager().sendQuery(sql);
		List<Typ> objectOfResutSet = new ArrayList<>();
		try {
			objectOfResutSet = DatabaseMapper.getObjectOfResutSet(System.getProperty("user.dir") + "/src/mapping/mapTyp.standartmapTyp", sendQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cbTyp.setCellFactory(new Callback<ListView<Typ>, ListCell<Typ>>() {
			
			@Override
			public ListCell<Typ> call(ListView<Typ> param) {
				final ListCell<Typ> cell = new ListCell<Typ>() {
                    {
                        super.setPrefWidth(100);
                    }    
                    @Override public void updateItem(Typ item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null) {
                                setText(item.getName());    
                          
                            } else {
                                setText(null);
                            }
                        }
            };
            return cell;
			}
		});
		cbTyp.getItems().addAll(objectOfResutSet);
		
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

	
	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
