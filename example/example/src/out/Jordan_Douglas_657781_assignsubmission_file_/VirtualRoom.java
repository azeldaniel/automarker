package out.Jordan_Douglas_657781_assignsubmission_file_;// Name: Jordan Douglas ID: 816022324
public class VirtualRoom
{
  private String name;
  private final int breakoutRoomLimit;
  private BreakoutRoom [] breakoutRooms=new BreakoutRoom[5]; 
  
  public VirtualRoom(String name){
      breakoutRoomLimit= 5; 
    }
  
  public VirtualRoom(String name,int limit){
      breakoutRoomLimit= limit;
      this.name=name;
        }  
   
  public int getNumberOfBreakoutRooms(){ 
      int i=0;
    while(breakoutRooms[i]!=null){
        i++;
    }    
    return i;
}
  
 public void createBreakoutRooms(){ 
    for(int i =0;i<5;i++){
        
        breakoutRooms[i]=new BreakoutRoom(name);
        
        
    }
  
    }
 public BreakoutRoom findBreakoutRoom(int roomNumber){
     if(roomNumber>breakoutRoomLimit){
        return null;
        }
    if(roomNumber==0){
        return breakoutRooms[roomNumber];
    }
     if(breakoutRooms[roomNumber-1]!=null){
     return breakoutRooms[roomNumber-1];
    }


    return null;
    
}
 public boolean closeBreakoutRoom(int roomNumber){ 
    BreakoutRoom b1= findBreakoutRoom(roomNumber);
    if(b1==null){
        return false;
    }
     b1.closeBreakoutRoom();
     return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber){ 
    BreakoutRoom b1= findBreakoutRoom(roomNumber);
    if(b1==null){
        return false;
    }
     b1.openBreakoutRoom();   
     return true;
    }
    
    public String listBreakoutRooms(){
        String list= name+ "\n";
        for(int i=0;i<breakoutRoomLimit;i++){ 
            list+= breakoutRooms[i].getBreakoutRoomID() +"\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){ 
      BreakoutRoom b1= findBreakoutRoom(roomNumber);
      if(b1==null){
          return null;
        }
        return b1.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber){
        BreakoutRoom b1= findBreakoutRoom(roomNumber);

        if(b1==null){
          return false;
        }
       return breakoutRooms[roomNumber].addParticipant(participantID);

}

public String findParticipantBreakoutRoom(String participantID){
    try{
    for ( int i=0;i<breakoutRoomLimit;i++){
        if(breakoutRooms[i].findParticipant(participantID).getParticipantID().equals(participantID)){
            return breakoutRooms[i].getBreakoutRoomID();
        }
        
    }
}
catch(Exception e){
    return null ;
}     
        return null;
}
}
