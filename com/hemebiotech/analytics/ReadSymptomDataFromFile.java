package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Implements the interface ISymptomReader in attempt to read symptoms from a file.
*
*/
public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  /**
   * This constructor specifies the filepath to reach.
   *
   * @param filepath a full or partial path to file with symptom strings in it, one per line
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (reader != null) {
            reader.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return result;
  }

}