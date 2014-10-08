package com.epam.WebDriver.Task1;

import com.epam.object.User;


public class Main {
public static void main(String[]args){
	User user=User.USER1;
	System.out.println(user.getPassword()+"  "+user.getUsername());
}
}
