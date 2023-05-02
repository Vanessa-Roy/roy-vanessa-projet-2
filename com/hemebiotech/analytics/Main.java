package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataToFile);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsCounter = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> symptomsCounterSorted = analyticsCounter.sortSymptoms(symptomsCounter);
        analyticsCounter.writeSymptoms(symptomsCounterSorted);
    }

}