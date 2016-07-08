package entities;

import java.util.Date;

public class Dauerauftrag {
	private Integer dauerauftragId;
	private Date endDatum;
	private Date startDatum;
	private Integer personId;
	private Double menge;
	private Integer typId;
	private Integer zyklusId;

	public void setDauerauftragId(Integer dauerauftragId) {
		this. dauerauftragId = dauerauftragId;
	}

	public Integer getDauerauftragId() {
		return dauerauftragId;
	}

	public void setEndDatum(Date endDatum) {
		this. endDatum = endDatum;
	}

	public Date getEndDatum() {
		return endDatum;
	}

	public void setStartDatum(Date startDatum) {
		this. startDatum = startDatum;
	}

	public Date getStartDatum() {
		return startDatum;
	}

	public void setPersonId(Integer personId) {
		this. personId = personId;
	}

	public Integer getPersonId() {
		return personId;
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

	public void setZyklusId(Integer zyklusId) {
		this. zyklusId = zyklusId;
	}

	public Integer getZyklusId() {
		return zyklusId;
	}

}