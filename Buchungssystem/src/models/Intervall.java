package models;

public class Intervall {

	private String name;
	private Integer tage;
	
	public Intervall(String name, Integer tage) {
		super();
		this.name = name;
		this.tage = tage;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getTage() {
		return tage;
	}
	public void setTage(Integer tage) {
		this.tage = tage;
	}
}
