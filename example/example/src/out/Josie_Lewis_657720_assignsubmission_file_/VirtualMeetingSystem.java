package out.Josie_Lewis_657720_assignsubmission_file_;import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Josie Lewis 816020986
 */
public class VirtualMeetingSystem
{
    public VirtualRoom virtualRooms;
    
    public void loadParticipantData(String filename ) {
      int i =0;
      String[] temp = new String[60];
        
        try {
      File myObj = new File(filename + ".dat");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        temp[i] = myReader.nextLine();
        System.out.println(temp[i]);
        i++; 
        
      }
      //once loop it exit close file
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    } 
    }
    
    public void createVirtualRoom(String name) {
        
        virtualRooms = new VirtualRoom(name,5);
        virtualRooms.createBreakoutRooms( );
        
    }
    
    
    public void allocateParticipants(String code ) {
        
        
    }
}
