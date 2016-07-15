package entities;

import java.sql.Date;

public class BudgetWithTyp {
	private Date datum;
	private Integer multiplikator;
	private Integer personIdFs;
	private Integer budgetId;
	private Double menge;
	private Integer typId;
	private Integer typIdFs;
	private String name;

	public void setDatum(Date datum) {
		this. datum = datum;
	}

	public Date getDatum() {
		return datum;
	}

	public void setMultiplikator(Integer multiplikator) {
		this. multiplikator = multiplikator;
	}

	public Integer getMultiplikator() {
		return multiplikator;
	}

	public void setPersonIdFs(Integer personIdFs) {
		this. personIdFs = personIdFs;
	}

	public Integer getPersonIdFs() {
		return personIdFs;
	}

	public void setBudgetId(Integer budgetId) {
		this. budgetId = budgetId;
	}

	public Integer getBudgetId() {
		return budgetId;
	}

	public void setMenge(Double menge) {
		this. menge = menge;
	}

	public Double getMenge() {
		return menge;
	}

	public void setTypId(Integer typId) {
		this. typId = typId;
	}

	public Integer getTypId() {
		return typId;
	}

	public void setTypIdFs(Integer typIdFs) {
		this. typIdFs = typIdFs;
	}

	public Integer getTypIdFs() {
		return typIdFs;
	}

	public void setName(String name) {
		this. name = name;
	}

	public String getName() {
		return name;
	}

}