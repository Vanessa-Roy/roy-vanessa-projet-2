package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String outFilePath;

	public WriteSymptomDataToFile (String outFilePath) {
		this.outFilePath = outFilePath;
	}

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFilePath, false)); // replace to existent text into the file
            for(Entry<String, Integer> entry : symptoms.entrySet()){
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
				e.printStackTrace();
		}
    }
}

