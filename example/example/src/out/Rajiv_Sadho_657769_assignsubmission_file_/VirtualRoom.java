package out.Rajiv_Sadho_657769_assignsubmission_file_;
/**
 * 816022655
 */
public class VirtualRoom {
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name) {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit) {
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms() {
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms() {
        for(int i = 0; i < breakoutRoomLimit; i++) {
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    // WARNING!: Assumes the room numbers entered starts at 1, so Room1, Room2, Room3 etc. Do not enter 0. 
    // The array still starts at 0 as per convention
    public BreakoutRoom findBreakoutRoom(int c) {
        if(breakoutRooms == null || breakoutRooms.length < c || c < 1) {
            return null;
        }
        
        return breakoutRooms[c - 1];
    }
    
    public boolean closeBreakoutRoom(int roomNumber) {
        BreakoutRoom bRoom = findBreakoutRoom(roomNumber);
        
        if(bRoom == null || !bRoom.getOpen()) {
            return false;
        }
        
        bRoom.closeBreakoutRoom();
        return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber) {
        BreakoutRoom bRoom = findBreakoutRoom(roomNumber);
        
        if(bRoom == null || bRoom.getOpen()) {
            return false;
        }
        
        bRoom.openBreakoutRoom();
        return true;
    }
    
    public String listBreakoutRooms() {
        String data = "Virtual Room Name: " + name + "\n";
        
        // Slightly hacky. All BreakoutRooms are created at once, so if the first one does not exist then all of them do not exist.
        if(findBreakoutRoom(1) == null)
            return data + "Empty\n";
        
            for(int i = 0; i < breakoutRoomLimit; i++) {
            data += breakoutRooms[i].getBreakoutRoomID() + "\n";
        }
        
        // TODO: Ask if "breakoutRoom_1 \n breakoutRoom_2 \n ... breakoutRoom_n" means 
        // return value cannot end in '\n' and adjust as required.        
        data = data.substring(0, data.length() - 1);
        
        return data;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber) {
        BreakoutRoom bRoom = findBreakoutRoom(roomNumber);
        
        if(bRoom == null) {
            return null;
        }
        
        return bRoom.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) {
        BreakoutRoom bRoom = findBreakoutRoom(roomNumber);
        
        if(bRoom == null || findParticipantBreakoutRoom(participantID) != null) {
            return false;
        }
        if(bRoom.addParticipant(participantID)) {
            return true;
        }    
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID) {
        // Slightly hacky. All BreakoutRooms are created at once, so if the first one does not exist then all of them do not exist.
        if(findBreakoutRoom(1) == null)
            return null;
        for(int i = 0; i < breakoutRoomLimit; i++) {
            if(breakoutRooms[i].findParticipant(participantID) != null) {
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        
        return null;
    }
}
