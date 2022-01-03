package out.Warren_Shanghie_657782_assignsubmission_file_;import java.util.Arrays;
/**
 * Write a description of class Participant here.
 *
 * @author (Warren Shanghie - 816020039)
 * @version (8/2/2021)
 */
public class VirtualRoom
{
  private String name;
  private int BreakoutRoomLimit;
  private BreakoutRoom[] breakoutRooms;
  
  
  
  //constructor:
  public VirtualRoom(String name){
      this.name = name;
      this.BreakoutRoomLimit = 5;
      this.breakoutRooms = new BreakoutRoom[BreakoutRoomLimit]; 
  }
  
  
  public VirtualRoom(String name, int limit){
      this.name = name;
      this.BreakoutRoomLimit = limit;
      this.breakoutRooms = new BreakoutRoom[limit]; 
  }
  
  
  //Behavior or methods:
  public int getNumberOfBreakoutRooms(){
    int count= 0;
    for(int i=0; i<BreakoutRoomLimit; i++){
        if(!breakoutRooms[i].equals(null)){
           count++;
        }
    }
    return count;
  }
  
 
  public void createBreakoutRooms(){
      for(int i=0; i<BreakoutRoomLimit; i++){
          breakoutRooms[i] = new BreakoutRoom(name); 
      }
  }
  
  
  public BreakoutRoom findBreakoutRoom(int roomNumber){
      String roomNum  = String.valueOf(roomNumber); 
      for(int i=0; i<BreakoutRoomLimit; i++){
        if(breakoutRooms[i].getBreakoutRoomID().contains(roomNum)){
            return breakoutRooms[i];
        }
    }
    return null; 
  }
  
  
  public boolean closeBreakoutRoom(int roomNumber){
    String roomNum  = String.valueOf(roomNumber); 
    
      for(int i=0; i<BreakoutRoomLimit; i++){
        if(breakoutRooms[i].getBreakoutRoomID().contains(roomNum)){
            breakoutRooms[i].closeBreakoutRoom();
            return true;
        }
    }
    return false; 
  }
  
  
  public boolean openBreakoutRoom(int roomNumber){
    String roomNum  = String.valueOf(roomNumber); 
      for(int i=0; i<BreakoutRoomLimit; i++){
        if(breakoutRooms[i].getBreakoutRoomID().contains(roomNum)){
            breakoutRooms[i].openBreakoutRoom();
            return true;
        }
    }
    return false;
  }
  
  
  public String listBreakoutRooms(){
     String rooms = "";
      for(int i=0; i<BreakoutRoomLimit; i++){
          //rooms += this.name +"\n"; 
          rooms += this.breakoutRooms[i].toString() + "\n\n";
     }
     return rooms;
  }
    
  public String listParticipantsInBreakoutRoom(int roomNumber){
     BreakoutRoom rooms; 
     String participants = ""; 
     rooms = findBreakoutRoom(roomNumber);
     if(rooms == null){
         return null;   
     }else{
         participants = rooms.listParticipants();
         return participants;
     }
  }
  
  public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
      String roomNum  = String.valueOf(roomNumber);
      
      for(int i=0; i<BreakoutRoomLimit; i++){
        if((breakoutRooms[i].findParticipant(participantID) != null) && (breakoutRooms[i].getOpen() != false)){
            return false;
        }
    }
    breakoutRooms[roomNumber].addParticipant(participantID);
    return true;
  }
  
  
  public String findParticipantBreakoutRoom(String participantID){
    String participant = ""; 
    for(int i=0; i<BreakoutRoomLimit; i++){
        if(breakoutRooms[i].findParticipant(participantID) != null){
            return breakoutRooms[i].getBreakoutRoomID();
        }
     }
    return null;
    }
}
