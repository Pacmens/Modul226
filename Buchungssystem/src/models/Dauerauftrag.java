package models;

import java.time.LocalDate;

public class Dauerauftrag {
	
	private Double menge;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer typId;
	private Integer zyklusId;
	private Integer personId;
	
	public Dauerauftrag(Double menge, LocalDate startDate, LocalDate endDate, Integer typId, Integer zyklusId,
			Integer personId) {
		super();
		this.menge = menge;
		this.startDate = startDate;
		this.endDate = endDate;
		this.typId = typId;
		this.zyklusId = zyklusId;
		this.personId = personId;
	}

	public Double getMenge() {
		return menge;
	}
	public void setMenge(Double menge) {
		this.menge = menge;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getTypId() {
		return typId;
	}
	public void setTypId(Integer typId) {
		this.typId = typId;
	}

	public Integer getZyklusId() {
		return zyklusId;
	}
	public void setZyklusId(Integer zyklusId) {
		this.zyklusId = zyklusId;
	}
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}	
}
