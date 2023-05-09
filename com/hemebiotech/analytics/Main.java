package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
* Instantiates ISymptomReader, ISymptomWriter and AnalyticsCounter to get the final document.
*
*/
public class Main {
  /**
  * Calls every method to get a file with the sorted symptoms and their quantities.
  *  
  * @param  args The command line arguments.
  */
  public static void main(String[] args) {

    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

    List<String> symptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> symptomsCounter = analyticsCounter.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsCounter);
    analyticsCounter.writeSymptoms(sortedSymptoms);
  }

}