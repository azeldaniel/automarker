package out.Ricky_Dindial_657721_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * Ricky Dindial
 * 816022023
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5];
    }
    
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[limit];
    }
    
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    
    public void createBreakoutRooms(){
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            if(i == roomNumber){
                return this.breakoutRooms[i];
            }
        }
        return null;
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
        breakoutRooms[roomNumber].closeBreakoutRoom();
        return true;
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
        breakoutRooms[roomNumber].openBreakoutRoom();
        return true;
    }
    
    
    public String listBreakoutRooms(){
        String listing = "Virtual Room List: " + "\n";
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            listing += breakoutRooms[i].toString() + "\n";
        }
        return listing;
    }
    
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String details;
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            if( i == roomNumber){
                details = breakoutRooms[roomNumber].listParticipants();
                return details;
            }
        }
        return null;
    }
    
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom room = new BreakoutRoom("Room");
        room = findBreakoutRoom(roomNumber);
        boolean addNewParticipant;
        
        if(room != null){
            addNewParticipant = room.addParticipant(participantID);
            if(addNewParticipant == true){
                return true; 
            }
        }
        return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            if(this.breakoutRooms[i].findParticipant(participantID)!=null){
                return breakoutRooms[i].toString();
            }
        }
        return null;
    }
}
