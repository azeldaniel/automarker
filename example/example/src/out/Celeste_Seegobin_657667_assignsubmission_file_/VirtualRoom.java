package out.Celeste_Seegobin_657667_assignsubmission_file_;//Celeste Seegobin -816019646
public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit = 5;
    private BreakoutRoom[] breakoutRooms; 
    
public VirtualRoom(String name){
        this.name = "Virtual Room";
        
}
    
public VirtualRoom(String name, int limit){
    this.name = "Virtual Room";
        
}
    
public int getNumberOfBreakoutRooms(){
        int numBreakoutRooms =0;
        for(int i=0; i<=breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID()!= null){
                numBreakoutRooms++;
            }
        else
        numBreakoutRooms = numBreakoutRooms;
        i++;
    }
return numBreakoutRooms;
}
    
   public void createBreakoutRooms(){
         for(int i=0; i<breakoutRoomLimit; i++){
         BreakoutRoom fill = new BreakoutRoom("Fill"); //Creating new object
         
    }
}

 public BreakoutRoom findBreakoutRoom(int roomNumber){
        int loc=0;
        for(int i=0; i<=roomNumber; i++){
            if(breakoutRooms[loc].equals(roomNumber)){
                return breakoutRooms[loc];
        }
    }
    return null;
}  
    
public boolean closeBreakoutRoom(int roomNumber){
         boolean close = false;
        if(close == true){
            breakoutRooms[roomNumber].closeBreakoutRoom();
         
      }
      return close;
    }
    
     
    
public boolean openBreakoutRoom(int roomNumber){
    boolean open = false;
    if(open == true){
        breakoutRooms[roomNumber].openBreakoutRoom();
        
}
return open;
}
    
    public String listBreakoutRooms(){
        String details;
        for(int i=0; i<=breakoutRoomLimit; i++){
            if(breakoutRoomLimit==0){
                details = "INVALID";
            }
            else{
                details = "List of BreakoutRooms:"+breakoutRooms[i];
            }
            return details;
    }
    return null;
}
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String list=null;
        if(roomNumber >= breakoutRoomLimit && roomNumber < breakoutRoomLimit){
            list = breakoutRooms[roomNumber].listParticipants();
            return list;
    }
    return null;
}
    
public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        //Making a new array
        BreakoutRoom[]newbreakoutRoom = new BreakoutRoom[breakoutRooms.length];
        for(int i=0; i<breakoutRooms.length; i++){
            if(findParticipantBreakoutRoom(participantID) == null){     
        return false;
    }
}
return true;
}
 
public String findParticipantBreakoutRoom(String participantID){
        int loc=0;
        for(int i=0; i<=breakoutRoomLimit; i++){
            if(breakoutRooms[loc].findParticipant(participantID)!= null){
                return participantID;
            }
    }
     return null;
}   
    //Accessors
public String getname(){
        return name;
   
}

public int getbreakoutRoomLimit(){
    return breakoutRoomLimit;
}

public BreakoutRoom[] breakoutRooms(){
    return breakoutRooms;
}
}
    
    
    














    
