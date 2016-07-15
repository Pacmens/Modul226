package entities;

import java.sql.Date;

public class Budget {
	private Date datum;
	private Integer personIdFs;
	private Integer budgetId;
	private Double menge;
	private Integer typIdFs;

	public void setDatum(Date datum) {
		this. datum = datum;
	}

	public Date getDatum() {
		return datum;
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

	public void setTypIdFs(Integer typIdFs) {
		this. typIdFs = typIdFs;
	}

	public Integer getTypIdFs() {
		return typIdFs;
	}

}