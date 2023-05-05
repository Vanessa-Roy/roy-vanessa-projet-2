package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

  private ISymptomReader reader;
  private ISymptomWriter writer;

  /**
   * This constructor specifies two objects that implement two differents interfaces.
   *
   * @param reader an object that implements ISymptomReader to read symptoms from a file
   * @param writer an object that implements ISymptomWriter to write symptoms/quantities in a file
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

    this.reader = reader;
    this.writer = writer;
  }

  /**
  * Get all the symptoms from the ISymptomReader.
  *  
  * @return a list of all Symptoms obtained from a data source, duplicates are probable
  */
  public List<String> getSymptoms() {
    List<String> symptoms = new ArrayList<String>();
    symptoms = reader.getSymptoms();
    return symptoms;
  }

  /**
  * Count the quantity of each symptoms.
  *  
  * @param symptoms a List with elements of type String represents all the symptoms
  * @return a Map with the symptom as key (String) and its quantity as value (Integer)
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> symptomsCounter = new HashMap<String, Integer>();
    for (String symptom : symptoms) {
      if (symptomsCounter.containsKey(symptom)) {
        symptomsCounter.put(symptom, symptomsCounter.get(symptom) + 1);
      } else {
        symptomsCounter.put(symptom, 1);
      }
    }
    return symptomsCounter;
  }

  /**
  * Sort the symptoms alphabetically.
  *  
  * @param symptomsCounter a Map with the symptom as key(String) and its quantity as value(Integer)
  * @return a Map with the same content but with sorted symptoms as key
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsCounter) {
    TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();
    sortedSymptoms.putAll(symptomsCounter);
    return sortedSymptoms;
  }

  /**
  * Write all symptoms and each quantity using ISymptomWriter.
  * @param sortedSymptoms a Map with the symptom as key (String) and its quantity as value (Integer)
  */
  public void writeSymptoms(Map<String, Integer> sortedSymptoms) {
    writer.writeSymptoms(sortedSymptoms);
  }
}