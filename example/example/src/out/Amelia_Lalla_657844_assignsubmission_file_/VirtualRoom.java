package out.Amelia_Lalla_657844_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author Amelia Lalla 816021543
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for (int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom room = null;
        if (roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            room = this.breakoutRooms[roomNumber-1];
        }
        return room;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        if (roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            this.breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if (roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            this.breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "Virtual Rooms: " + "\n";
        if (breakoutRoomLimit == 0){
            details += "No Virtual Rooms" + "\n";
        }
        else{
            for (int i=0; i<breakoutRoomLimit; i++){
                details += breakoutRooms[i].toString() + "\n" + "\n";
            }
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String list = "";
        if (roomNumber-1 >= 0 && roomNumber-1 < breakoutRoomLimit){
            list = breakoutRooms[roomNumber-1].listParticipants() + "\n";
        }
        return list;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        String check = null;
        boolean added = false;
        if (roomNumber-1 >= 0 && roomNumber-1 < breakoutRoomLimit){
            check = findParticipantBreakoutRoom(participantID);
            if (check == null){
                added = this.breakoutRooms[roomNumber-1].addParticipant(participantID); 
                return added;
            }
        }
        return added;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for (int i=0; i<this.breakoutRoomLimit; i++){
            
            if (this.breakoutRooms[i].findParticipant(participantID) != null){
                return this.breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
}
