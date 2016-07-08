package entities;

public class Person {
	private Boolean isAdmin;
	private String passwort;
	private Integer personId;
	private String email;
	private String name;

	public void setIsAdmin(Boolean isAdmin) {
		this. isAdmin = isAdmin;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setPasswort(String passwort) {
		this. passwort = passwort;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPersonId(Integer personId) {
		this. personId = personId;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setEmail(String email) {
		this. email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this. name = name;
	}

	public String getName() {
		return name;
	}

}