package out.Ishika_Gopie_657680_assignsubmission_file_;
/**
 * StudentID: 816018253
 */
public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[10];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit; 
    }
    
    public void createBreakoutRooms(){
        for(int i = 0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
       if(roomNumber <= 0 || roomNumber > breakoutRoomLimit){
           return null;
        }
       if (breakoutRooms[roomNumber - 1] != null){
           return breakoutRooms[roomNumber - 1];
        }
        return null;
    }
    
   public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if(breakoutRoom == null){
            return false;
        }
        if(breakoutRoom.getOpen() == false){
            return true;
        }
        else{
            breakoutRoom.closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if(breakoutRoom == null){
            return false;
        }
        if(breakoutRoom.getOpen() == true){
            return true;
        }
        else{
            breakoutRoom.openBreakoutRoom();
            return true;
        }
    }
    
    String listBreakoutRooms(){
        String s = "";
        s = "Virtual Room name: " + name + "\n";
        s = "BreakoutRoom IDs: ";
        for (int i = 0 ; i < breakoutRoomLimit; i++){
            s = s + breakoutRooms[i].getBreakoutRoomID() + " ";
        }
        return s;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        String s = "";
        if (breakoutRoom == null){
            s = "Breakout room not found! ";
        }
        else{
            s = breakoutRoom.listParticipants();
        }
        return s;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom == null){
            System.out.println("Room not found");
            return false;
        }
        return breakoutRoom.addParticipant(participantID);
    }
    
    
    public String findParticipantBreakoutRooom(String participantID){  
        String ID;
        if( participantID.length() != 8 || participantID == null){
            return null;
        }
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
}
