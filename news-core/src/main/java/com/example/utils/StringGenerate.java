package com.example.utils;

import java.util.Random;

public class StringGenerate {

	public static String generateValue(int length) {
		String pass = "";
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		final int N = alphabet.length();
		Random r = new Random();
		for (int i = 0; i <= length; i++) {
			pass += alphabet.charAt(r.nextInt(N));
		}
		return pass;
	}
}
