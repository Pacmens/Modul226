package models;

import java.time.LocalDate;

public class Budget {
	
	private Double wert;
	private LocalDate startDate;
	private String operation;
	private LocalDate endDate;
	private Boolean dauerauftrag;
	private String zyklus;
		
	public Budget(Double wert, LocalDate startDate, String operation, LocalDate endDate, boolean dauerauftrag, String zyklus) {
		this.wert = wert;
		this.startDate = startDate;
		this.operation = operation;
		this.endDate = endDate;
		this.dauerauftrag = dauerauftrag;
		this.zyklus = zyklus;
	}

	public Budget(Double wert, LocalDate startDate, String operation) {
		this.wert = wert;
		this.startDate = startDate;
		this.operation = operation;
		this.endDate = startDate;
		this.dauerauftrag = false;
		this.zyklus = "";
	}
	
	public Double getWert() {
		return wert;
	}
	public void setWert(Double wert) {
		this.wert = wert;
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
	public boolean isDauerauftrag() {
		return dauerauftrag;
	}
	public void setDauerauftrag(boolean dauerauftrag) {
		this.dauerauftrag = dauerauftrag;
	}
	public String getZyklus() {
		return zyklus;
	}
	public void setZyklus(String zyklus) {
		this.zyklus = zyklus;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
