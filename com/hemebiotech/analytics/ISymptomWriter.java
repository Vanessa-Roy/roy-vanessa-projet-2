package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Anything the will write symptom data on a valid data output format.
 *
 */
public interface ISymptomWriter {
  /**
 * This method permits to write down the dictionnary of all symptoms and each quantity.
 *  
 * @param symptoms a Map with the symptom as key (String) and his quantity as value (Integer)
 */
  public void writeSymptoms(Map<String, Integer> symptoms);
}
