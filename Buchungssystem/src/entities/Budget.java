package entities;

import java.sql.Date;

public class Budget {
	private Date datum;
	private Integer personId;
	private Integer budgetId;
	private Double menge;
	private Integer typId;

	public void setDatum(Date datum) {
		this. datum = datum;
	}

	public Date getDatum() {
		return datum;
	}

	public void setPersonId(Integer personId) {
		this. personId = personId;
	}

	public Integer getPersonId() {
		return personId;
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

}