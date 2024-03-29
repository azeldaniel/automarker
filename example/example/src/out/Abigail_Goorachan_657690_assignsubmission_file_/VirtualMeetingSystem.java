package out.Abigail_Goorachan_657690_assignsubmission_file_;/**
 * 816007500
 */
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class VirtualMeetingSystem
{
    VirtualRoom VR;
    
    public void loadParticipantData(String filename) throws FileNotFoundException{
        String[] studentIDsArray = new String[100];
        File studentIDs = new File(filename);
        Scanner myReader = new Scanner(studentIDs);
        while(myReader.hasNextLine()){
            String studentID = myReader.nextLine();
            for(int i=0; i<studentIDsArray.length; i++){
                studentIDsArray[i] = studentID;
                studentID = myReader.nextLine();
            }
        }
    }
    
    public void createVirtualRoom(String name){
        //VirtualRoom VR;
        VR = new VirtualRoom(name); //automatically creates a virtual room with 5 breakout rooms 
    }
    
    public void allocateParticipants(String code){
        
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return true;
    }
    
    public String listsParticipants(int roomNumber){
      return "";  
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return VR.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return VR.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if(participantID.length() == 8){
            return VR.findParticipantBreakoutRoom(participantID);
        }
        else{
            return null;
        }
    }
    
    public String listAllBreakoutRooms(){
        return VR.listBreakoutRooms();
    }
    
   public String listParticipantsInAllBreakoutRooms(){
        //loop through all breakout rooms in the array
        //call VR.listParticipantsInBreakoutRoom(roomNumber)
        return "";
    } 
    
    //https://www.w3schools.com/java/java_files_read.asp 
}
