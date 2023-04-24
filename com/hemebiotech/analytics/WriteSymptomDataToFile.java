package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    Map<String, Integer> symtpoms = new HashMap<String, Integer>();
    public void addSymptom() {
        Iterator<String> resultList;
        resultList = result.iterator();
        String symptom;
        while (resultList.hashNext()) {
            if (symptoms.containsKey(symptom)) {
                symptoms.put(symptom, symptoms.get(symptom) + 1);
		    } else {
                symptoms.put(symptom, 1);
		    }
            symptom = resultList.next();
        }
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symtpoms) {
        FileWriter fileWriter = new FileWriter("result.out", false); // replace to existent text in result.out
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {

            for(Entry<String, Integer> entry:symptoms.entrySet()){
                writer.write(entry.getKey() + ": " + entry.getValue() +"\n");
            } 
            writer.close();

        } catch (IOException e) {
				e.printStackTrace();
		}
    }




}

