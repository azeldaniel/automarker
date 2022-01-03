package out.Sadiyya_Ali_657734_assignsubmission_file_;//816013697
public class VirtualRoom {
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int counter = 0;
    
    public VirtualRoom (String name) {
        this.name = name;
        this.breakoutRoomLimit = 5;
    }
    
    public VirtualRoom (String name, int limit) {
        this.name = name;
        this.breakoutRoomLimit = limit;
    }
    
    public int getNumberOfBreakoutRooms() {
        int number = breakoutRooms.length;
        return number;
    }
    
    public void createBreakoutRooms() {
        String breakoutRoomList = ("");
        
        BreakoutRoom b = new BreakoutRoom(breakoutRoomList);
        breakoutRooms[counter] = b;
        counter++;
    }
    
    public BreakoutRoom findBreakoutRoom (int roomNumber) {
        int number = getNumberOfBreakoutRooms();
        
        for (int j = 0; j < number; j++) {
            if (j == roomNumber) {
                return breakoutRooms[j];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom (int roomNumber) {
        int number = getNumberOfBreakoutRooms();
        
        for (int j = 0; j < number; j++) {
            if (j == roomNumber) {
                breakoutRooms[j].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom (int roomNumber) {
         int number = getNumberOfBreakoutRooms();
        
        for (int j = 0; j < number; j++) {
            if (j == roomNumber) {
                breakoutRooms[j].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms() {
        String breakoutRoomsList = "Virtual Room Name: " +name +"\n";
        int number = getNumberOfBreakoutRooms();
        
        for (int j = 0; j < number; j++) {
            breakoutRoomsList += breakoutRooms[j];
        }
        return breakoutRoomsList;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber) {
        String participantsList = "List of Participants: " +"\n";
        participantsList += breakoutRooms[roomNumber].listParticipants();
        return participantsList;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber) {
        int number = getNumberOfBreakoutRooms();
        
        if (number < 5 && breakoutRooms[roomNumber] != null) {
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID) {
        int number = getNumberOfBreakoutRooms();
        Participant p = new Participant(participantID);
        
        for (int j = 0; j < number; j++) {
            p = breakoutRooms[j].findParticipant(participantID);
            
            if (p != null) {
                String breakoutRoomDetails = ("");
                breakoutRoomDetails = breakoutRooms[j].getBreakoutRoomID();
                return breakoutRoomDetails;
            }
        }
        return null;
    }
}
