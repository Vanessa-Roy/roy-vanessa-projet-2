package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedPupilCount = 0;

	public static void main(String args[]) throws Exception {
		// first get input
		FileReader fileReader = new FileReader("symptoms.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashes: " + rashCount);
			} else if (line.contains("dialated pupils")) {
				dialatedPupilCount++;
				System.out.println("number of dialated pupils: " + dialatedPupilCount);
			}

			line = reader.readLine(); // get another symptom
		}

		reader.close();

		// next generate output
		FileWriter writer = new FileWriter("result.out", false); // replace to existent text in result.out
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilCount + "\n");
		writer.close();
	}
}