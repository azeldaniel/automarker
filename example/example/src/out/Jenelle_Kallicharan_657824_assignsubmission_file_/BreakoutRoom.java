package out.Jenelle_Kallicharan_657824_assignsubmission_file_;//ID: 816117683
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.io.FileWriter;   
import java.io.IOException;  

/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class BreakoutRoom {
  public static void main(String[] args) {
     String addParticipant;
    try {
      FileWriter myWriter = new FileWriter("BreakoutRoom.txt");
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the 8 digit ID: ");
      addParticipant= keyboard.nextLine();
      
      Scanner sc1 = new Scanner(System.in);
   
      addParticipant = sc1.next();
      boolean flag = false;
      int count = 0;
     
      File file = new File("participant.txt");
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextLine()) {
         String line = scanner.nextLine();
         System.out.println(line);
         if(line.indexOf(addParticipant)!=-1) {
            flag = true;
            count = count+1;
         }
      }
      if(flag) {
         System.out.println("File contains ID " + addParticipant);
         
      } else {
         System.out.println("File does not contain ID");
           myWriter.write(addParticipant);
           myWriter.close();
         
      }
   
      
    } catch (IOException e) {
      System.out.println("Error reading file. Terminating.");
      e.printStackTrace();
    }
  }
  
 
}