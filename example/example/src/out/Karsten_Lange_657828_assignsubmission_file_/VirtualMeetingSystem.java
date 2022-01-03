package out.Karsten_Lange_657828_assignsubmission_file_;


import java.util.*;
//ID:816014018
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class VirtualMeetingSystem{
    private String[] allocations = new String[100]; 
    private VirtualRoom vroom;
    private String name;
    
    
    public void loadParticipantData(String filename){
        
        try {
      int i = 0;
      File participantData = new File(filename);
      Scanner myReader = new Scanner(participantData);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        allocations[i] = data;
        i++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
    
        
    }
    
    
    
    
    public void  createVirtualRoom(String name){
        this.name = name;
        this.vroom = new VirtualRoom(name);
    }
    
    public void allocateParticipants(String code){
        String participant;
       
        vroom.createBreakoutRooms();
        
        if(code.compareTo("C5")==0){
            int allocationsCounter = 0;
            for(int i=0; i<5; i++){
                for(int y=0; y<5; y++){
                    participant = allocations[allocationsCounter];
                    vroom.addParticipantToBreakoutRoom(participant, i);
                    allocationsCounter++;
                }
                
            }
            
        }
    }
    
    
    
    public boolean addParticipant(String participantID, int roomNumber){
        
        if(vroom.addParticipantToBreakoutRoom(participantID, roomNumber)== true){
       
            return true ;
        }
        return false;
    }
    
    
    
    public String listParticipants(int roomNumber){
        
        return vroom.listParticipantsInBreakoutRoom(roomNumber);
        
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
        if(vroom.openBreakoutRoom(roomNumber) == true){
            
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
        if(vroom.closeBreakoutRoom(roomNumber) == true){
            return true;
        }
        
        return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        return vroom.findParticipantBreakoutRoom(participantID);
    }
    
    
    
    
    
    public String listAllBreakoutRooms(){
        
        return vroom.listBreakoutRooms();
        
        
        
    }
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
