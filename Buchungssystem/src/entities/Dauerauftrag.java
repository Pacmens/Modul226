package entities;

import java.sql.Date;

public class Dauerauftrag {
	private Integer dauerauftragId;
	private Date endDatum;
	private Integer zyklusIdFs;
	private Integer personIdFs;
	private Date startDatum;
	private Double menge;
	private Integer typIdFs;

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

	public void setZyklusIdFs(Integer zyklusIdFs) {
		this. zyklusIdFs = zyklusIdFs;
	}

	public Integer getZyklusIdFs() {
		return zyklusIdFs;
	}

	public void setPersonIdFs(Integer personIdFs) {
		this. personIdFs = personIdFs;
	}

	public Integer getPersonIdFs() {
		return personIdFs;
	}

	public void setStartDatum(Date startDatum) {
		this. startDatum = startDatum;
	}

	public Date getStartDatum() {
		return startDatum;
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