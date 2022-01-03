package out.Warren_Shanghie_657782_assignsubmission_file_; import java.util.Arrays;
import java.util.LinkedHashSet;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Write a description of class Participant here.
 *
 * @author (Warren Shanghie - 816020039)
 * @version (8/2/2021)
 */
public class VirtualMeetingSystem
{
    private VirtualRoom virtualRoom;
    private String participants[];

     
    // default constructor:
    public VirtualMeetingSystem()
    {
        this.participants = new String[50];
    }
    
    //behavior or methods:
    public void loadParticipantData(String filename){
        BufferedReader reader; 
        
        try {
          int count = 0;
          String duplicatedParticipants[] = new String[50];
          reader = new BufferedReader(new FileReader("participant.dat"));
          String line = reader.readLine();
          while(line!=null){
              duplicatedParticipants[count] = new String(line);
              line = reader.readLine();
              count++; 
          }
          reader.close();
          LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>( Arrays.asList(duplicatedParticipants)); // found on: https://howtodoinjava.com/java/array/array-remove-duplicate-elements/
          this.participants = linkedHashSet.toArray(new String[] {});                                    //found on:  https://howtodoinjava.com/java/array/array-remove-duplicate-elements/
        
        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
 
    public void createVirtualRoom(String name){
           virtualRoom = new VirtualRoom(name);
           virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
       if(code.equals("C5")){
           int x=0;
           int i=0;
           for(i=0; i<50; i++){  
            if((i%5 == 0) && (i != 0) ){
             x++;    
            }
            if(x==5){
                x=0;
            }
            virtualRoom.addParticipantToBreakoutRoom(participants[i],x);
           }  
       }else if(code.equals("RR")){
            System.out.println("Sorry they.. nah just nah"); 
            
       }
    }
    
    public boolean addParticipants(String participantID, int roomNumber){
          boolean placeParticipant = this.virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
       return placeParticipant;
    }
    
    
    public String listParticipants(int roomNumber){
      String Participants = ""; 
      Participants += this.virtualRoom.listParticipantsInBreakoutRoom(roomNumber); 
      return Participants; 
    }
    
   
    public boolean openBreakoutRoom(int roomNumber){
        boolean openBR = this.virtualRoom.openBreakoutRoom(roomNumber);
        return openBR; 
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean closeBR = this.virtualRoom.closeBreakoutRoom(roomNumber); 
        return closeBR; 
    }
    
    
    public String findParticipantBreakoutRoom(String ParticipantID){
       String participantBrId = "";
       participantBrId = this.virtualRoom.findParticipantBreakoutRoom(ParticipantID); 
       if(participantBrId == null){
          participantBrId = ParticipantID + " not found(null)";
       }
        return participantBrId;
    }
    
   
    public String listAllBreakoutRooms(){
       String rooms = virtualRoom.listBreakoutRooms();
     return rooms; 
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participant = ""; 
        for(int i=1; i<=virtualRoom.getNumberOfBreakoutRooms(); i++){
            participant += this.virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }   
        return participant;
    }
    
}
