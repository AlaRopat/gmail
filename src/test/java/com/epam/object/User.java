package com.epam.object;

import java.io.FileInputStream;
import java.util.Properties;

public enum User {
	USER1, USER2, USER3;

	public String getProperty(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resource/users.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(this.name() + "." + key);
	}

	public String getUsername() {
		return getProperty("username");
	}

	public String getPassword() {
		return getProperty("password");
	}

}
