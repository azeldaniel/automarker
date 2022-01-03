package out.Jediah_Castle_657839_assignsubmission_file_;public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name)
     {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom( String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms( ){
        return breakoutRoomLimit;
    }
   
    public void createBreakoutRooms(){
        for(int i = 0; i < breakoutRoomLimit; i++){
        breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
           if(breakoutRooms[roomNumber] != null){
             return breakoutRooms[roomNumber];
            }
           return null;    
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber - 1] != null){
            breakoutRooms[roomNumber - 1].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber - 1] != null){
            breakoutRooms[roomNumber - 1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
  
    public String listBreakoutRooms(){
          String list = "Breakout Room";
          for(int i = 0; i < breakoutRoomLimit; i++){
           list += "\n" + breakoutRooms[i].toString();
          }
          return list;
        }
    
  
    public String listParticipantsInBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber - 1] != null){
            String ListP = " Participant In Breakout Room "+ breakoutRooms[roomNumber-1].getBreakoutRoomID();
            ListP += breakoutRooms[roomNumber].listParticipants();
            return ListP;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) {
        roomNumber -= 1;
        if(breakoutRooms[roomNumber] != null){
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i = 0; i < breakoutRoomLimit; i++){
             breakoutRooms[i].findParticipant(participantID);
              if( participantID.equals(breakoutRooms[i].findParticipant(participantID))){
                  return breakoutRooms[i].getBreakoutRoomID();
              }     
        }
        return null;
    }
      /*
     //Used for testing
     public static void  main(String[] args){ 
         
        VirtualRoom v1 = new VirtualRoom("Seminar");
        v1.createBreakoutRooms();
       // System.out.println(v1.listBreakoutRoom());
        
    } 
    */
}
