package models;

public class Person {
	private Integer personId;
	private String name;
	private String email;
	private String password;
	private Boolean isAdmin;
	
	public Person() {}
	
	public Person(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		setIsAdmin(false);
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
