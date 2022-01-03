package out.Alec_Sieupresad_657762_assignsubmission_file_;// Student ID: 816022470
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualMeetingSystem{
    private String filename;
    private String name;
    private String code;
    private String participantID;
    private int roomNumber;
    private VirtualRoom virtualR;
    
    public void loadParticipantData (String filename){
        try {
             File myObj = new File(filename);
             Scanner myReader = new Scanner(myObj);
                int i;
                i = 0;
                String[] readArray;
                readArray = new String[1000]; 
                while (myReader.hasNextLine()) {
                   String data = myReader.nextLine();
                   System.out.println(data);
                   readArray[i] = data;
                   i++;
                }
              myReader.close();
              } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
                    e.printStackTrace();
            }
    }
        
      
    /*
    public void createVirtualRoom (String name){
        
    }
    
    public void allocateParticipants (String code){
        
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        
    }
    
    public String listParticipants (int roomNumber){
        
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
    }
        
    public String findParticipantBreakoutRoom (String participantID){  
        
    }
    
    public String listAllBreakoutRooms( ){
        
    }
    
    public String listParticipantsInAllBreakoutRooms( ){
        
    }
    
    public static void main(String[] args){
        
 
    }
   */
}

// The "Try, Catch" used in loadParticipantData was adapted from w3schools and can be found at the following link:
// https://www.w3schools.com/java/java_files_read.asp
