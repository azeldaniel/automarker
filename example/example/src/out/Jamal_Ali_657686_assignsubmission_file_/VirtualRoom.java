package out.Jamal_Ali_657686_assignsubmission_file_;
/**
 *Virtual Room Class
 *The VirtualRoom class models a virtual room in the virtual meeting system. A virtual room creates and
 *manages up to a certain number of breakout rooms
 * Jamal Ali
 * ID: 816014616
 */
public class VirtualRoom
{
    // instance variables 
    private String name;
    private final int breakoutRoomLimit = 5;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    /**
     *Methods for BreakoutRoom Class
     */
    public int getNumberOfBreakoutRooms()
    {
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for (int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 1; i<=breakoutRoomLimit;i++){
            if(roomNumber == i){
                return breakoutRooms[i-1];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!= null){
           findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
     public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!= null){
           findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true;
        }
        return false;
    }
   
    public String listBreakoutRooms(){
        String list = "All rooms in " + name + "\n \n";
        for(int i=0; i<breakoutRoomLimit; i++){
            list += breakoutRooms[i].toString() + "\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String list = "";
        if(findBreakoutRoom(roomNumber)!=null){
            list += findBreakoutRoom(roomNumber).listParticipants();
            return list;
        }
        else{
            return null;
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(findBreakoutRoom(roomNumber)!=null){
            findBreakoutRoom(roomNumber).addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
            for(int i=0; i<breakoutRoomLimit;i++){
                   if (participantID.equals(breakoutRooms[i].findParticipant(participantID))){
                       return participantID;
                    }
                }
          return null;
    }
}
