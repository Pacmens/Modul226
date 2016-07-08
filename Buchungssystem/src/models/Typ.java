package models;

public class Typ {
	
	private String name;
	private Integer multiplikator;
	
	
	public Typ(String name, Integer multiplikator) {
		super();
		this.name = name;
		this.multiplikator = multiplikator;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getMultiplikator() {
		return multiplikator;
	}
	public void setMultiplikator(Integer multiplikator) {
		this.multiplikator = multiplikator;
	}
}
