package com.epam.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Utils {
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random rnd = new Random();
	private static WebDriver driver;

	public static String getRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public static void checkAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {

		}

	}

	public static File getFile(int fileSize) throws IOException {
		File file = new File("src/file.txt");
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
//		rf.seek(0);
		rf.setLength(fileSize * 1024 * 1024);
		return file;

	}
}
