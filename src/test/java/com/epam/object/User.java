package com.epam.object;

public enum User {
	USER1("olgakumova335@gmail.com", "Bittersweet789"), USER2(
			"olgaadam438@gmail.com", "Bittersweet789"), USER3(
			"loraadams25@gmail.com", "Bittersweet789");
	private String username;
	private String password;

	User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
}
