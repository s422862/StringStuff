/*
* String blowUp
* This program gets the input from a text file, and
* whatever number is next to the character, it prints
* it out that amount of times.
* The output goes to an output text file, and the console
* @author  John Omage
* @version 1.0
* @since 2020-09-28.
*/

// import 
import java.io.*;

public class BlowUpMain {
 
  /**.
  // main
  */
  public static void main(String[] args) {
       
    // The name of the file to open.
    String inputText = "input.txt";

    // This will reference one line at a time
    String line = null;

    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(inputText);

      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        String userInput = line;
        System.out.println(blowup(userInput));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"), true);
        out.write(blowup(userInput));
        out.close();
      }
      // Always close files.
      bufferedReader.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + inputText + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + inputText + "'");
    }
  }
 
  /**.
  // Blows up the string, then returns it using StringBuilder
  */
  public static String blowup(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (!isNumeric(str.substring(i, i + 1))) {
        sb.append(str.charAt(i));
      } else {
        sb.append(lengthen(str.charAt(i + 1),
            Integer.parseInt(str.substring(i, i + 1))));
      }
    }
    return sb.toString();
  }
 
  /**.
  // Checks if the text is numeric or not
  */
  public static boolean isNumeric(String str) {
    try {
      int num = Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
 
  /**.
  // Lengthens the string, by adding the chars and digits to it
  */
  public static String lengthen(char c, int i) {
    if (i == 0 || c == ' ') {
      return "";
    }
    int count = 0;
    StringBuilder sb = new StringBuilder(c);
    while (count != i) {
      sb.append(c);
      count++;
    }
    return sb.toString();
  }
}