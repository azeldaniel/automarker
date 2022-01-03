package out.Jenelle_Kallicharan_657824_assignsubmission_file_;//ID: 816117683
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

/* Write a description of class TEST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Participant {
  public static void main(String[] args) {
      boolean verifyID=true;
    try {
      File file = new File("participant.txt");
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        verifyID=isNumeric(data);
        if(verifyID==true){
        System.out.print(data + " True"+ "\n");
    }
    
        else System.out.print(data + " False" + "\n");
        
        
      }
      scanner.close();
    } catch (FileNotFoundException a) {
      System.out.println("Error reading file. Terminating.");
      a.printStackTrace();
    }
    
    
  }
  
  public static boolean isNumeric(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
    } 
    catch(NumberFormatException a){  
    return false;  
    }  
}
}



