package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader read, ISymptomWriter write) {
        reader = read;
        writer = write;
    }

    public List<String> getSymptoms() {
        List<String> symptoms = new ArrayList<String>();
        symptoms = reader.getSymptoms();

        return symptoms;
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        for (String symptom : symptoms) {
            if (counter.containsKey(symptom)) {
                counter.put(symptom, counter.get(symptom) + 1);
		    } else {
                counter.put(symptom, 1);
		    }
        }
        return counter;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();
        sortedSymptoms.putAll(symptoms);
        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}