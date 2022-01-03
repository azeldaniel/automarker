package out.Jean___Luke_Chankoo_657705_assignsubmission_file_;//816006490
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom [] breakoutRooms;
    

    public VirtualRoom(String name)
    {
      name=name;
      breakoutRoomLimit=5;
    }
    
    public VirtualRoom(String name, int limit){
        name=name;
        breakoutRoomLimit=limit;
    }
 
    public int getNumberOfBreakoutRooms(){
    int count=0;
    for(int i=0; i<breakoutRoomLimit;i++){
        count=count+1;
    }
    return count;
    }
    
    public void createBreakoutRooms(){
        
        BreakoutRoom b[]= new BreakoutRoom[5];
        
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber]!=null){
            return breakoutRooms[roomNumber];
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        int numRooms=getNumberOfBreakoutRooms();
        for(int i=0; i<numRooms;i++){
          if(breakoutRooms[i].equals(roomNumber)){
              return true;
            }  
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        int numRooms=getNumberOfBreakoutRooms();
        for(int i=0; i<numRooms;i++){
          if(breakoutRooms[i].equals(roomNumber)){
              return true;
            }  
        }
        return false;            
    }
    
    public String listBreakoutRooms(){
    System.out.println(name);
    String details;
    details= Arrays.toString(breakoutRooms);
    
    return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    
    String detail;

        int numRooms=getNumberOfBreakoutRooms();
       for(int i=0; i<numRooms;i++){
          if(breakoutRooms[i].equals(roomNumber)){
           detail=breakoutRooms[roomNumber].listParticipants();    
           return detail;
            }  
        }
    return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
    int numRooms=getNumberOfBreakoutRooms();
        for(int i=0; i<numRooms;i++){
          if(breakoutRooms[i].equals(roomNumber)){
              breakoutRooms[i].addParticipant(participantID);
              return true;
            }  
        }
        return false;
        
    }
    
    public String findParticipantBreakoutRoom(String participantID){
    
    
    int n=getNumberOfBreakoutRooms();
    for(int i=0; i<n;i++){
        
        if(breakoutRooms[n].findParticipant(participantID).equals(participantID)){
        
        return breakoutRooms[n].toString();
        }
    }
    
    return null;
    }
    
    }
