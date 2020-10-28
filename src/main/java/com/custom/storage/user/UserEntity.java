package com.custom.storage.user;


public class UserEntity {
	private String id; // unique id of the user in the database
	private String loginName; // login user name
	private String email;
	private String passWord;
	private String firstName;
	private String lastName;

	public UserEntity(String loginName, String email, String passWord, String firstName, String lastName) {
		this.id = loginName;
		this.loginName = loginName;
		this.email = email;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", loginName=" + loginName + ", email=" + email
		+ ", password=" + passWord  + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
