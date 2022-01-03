package out.Michael_Rampersad_657747_assignsubmission_file_;import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualMeetingSystem
{
    private String list = null;
    
    public void loadParticipantData(String filename)
    {
         try {
             int i=0;
             File myObj = new File(filename);
             Scanner myReader = new Scanner(myObj);
             while (myReader.hasNextLine()) {
                 String data = myReader.nextLine();
                 System.out.println(data);
                } 
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
         }
    } 
    
    public void createVirtualRoom (String name){
    
    }
    
    public void allocateParticipants (String code){
    }
    
    public boolean addparticipant (String participantID, int roomNumber){
        return true;
    }
    
    public String listParticipants (int roomNumber){
        return list;
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        return true;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        return true;
    }
    
    //public String findParticipantBreakoutRoom (String participantID){
    //return breakoutRoomID;
    // }
    
    //public String listAllBreakoutRooms(){
    //    return listRooms;
    // }
    
    //public listParticipantsInAllBreakoutRooms(){
    //    return listPart;
    //}
   
}
