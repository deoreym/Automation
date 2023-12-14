package com.EdwiserRemUI.PageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorConversion {

	public static String rgbToHex(int red, int green, int blue) {
		// Validate input values
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException("Invalid RGB values");
		}

		// Combine components into a single integer value
		int rgb = (red << 16) | (green << 8) | blue;

		// Convert the integer value to hexadecimal string
		String hexColor = Integer.toHexString(rgb).toUpperCase();

		// Pad with zeros if necessary
		while (hexColor.length() < 6) {
			hexColor = "0" + hexColor;
		}

		return "#" + hexColor; // Add hash symbol
	}

	public static String Color(String rgbaString) {
//        String rgbaString = "rgba(15, 200, 188, 1)";
		String Hex = "";
		int[] rgbaValues = extractRGBAValues(rgbaString);

		if (rgbaValues != null) {
			int red = rgbaValues[0];
			int green = rgbaValues[1];
			int blue = rgbaValues[2];

//			System.out.println("Red: " + red);
//			System.out.println("Green: " + green);
//			System.out.println("Blue: " + blue);
			Hex = rgbToHex(red, green, blue);
		} else {
			System.out.println("Invalid RGBA string format.");
		}
		return Hex;
	}

	public static int[] extractRGBAValues(String rgbaString) {
		int[] rgbaValues = new int[4];

		// Regular expression pattern to match rgba values
		String regex = "rgba\\((\\d+),\\s*(\\d+),\\s*(\\d+),\\s*(\\d*\\.?\\d+)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rgbaString);

		if (matcher.matches()) {
			rgbaValues[0] = Integer.parseInt(matcher.group(1));
			rgbaValues[1] = Integer.parseInt(matcher.group(2));
			rgbaValues[2] = Integer.parseInt(matcher.group(3));
			return rgbaValues;
		}

		return null; // Return null if no match
	}
	
	public static String convertRGBtoRGBA(String rgbColor) {
        // Convert RGB to RGBA by adding alpha value (assuming alpha is 1.0 for fully opaque)
        return rgbColor.replace("rgb", "rgba").replace(")", ", 1.0)");
    }
}
