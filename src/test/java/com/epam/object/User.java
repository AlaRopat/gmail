package com.epam.object;

public enum User {
	USER1("user1fortestwebdriver@gmail.com", "Bittersweet789"), USER2(
			"user2fortestwebdriver@gmail.com", "Bittersweet789"), USER3(
			"user3fortestwebdriver@gmail.com", "Bittersweet789");
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
