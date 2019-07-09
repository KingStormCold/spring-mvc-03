package com.example.utils;

import java.text.Normalizer;

public class CustomELUtils {

	public static String seoURL(String input) {
		if (input == null) {
			return "";
		} else {
			String result = Normalizer.normalize(input, Normalizer.Form.NFD);
			result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			result = result.replace('đ', 'd');
			result = result.replace('Đ', 'D');
			result = result.replaceAll("_", "-");
			result = result.replaceAll("[^a-z A-Z0-9-]", "");
			result = result.replaceAll(" ", "-");
			result = result.replaceAll("--", "-");
			return result.toLowerCase();
		}
	}
}
