package out.Rajiv_Sadho_657769_assignsubmission_file_;
/**
 * 816022655
 */
public class BreakoutRoom {
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name) {
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        open = true;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
    }
    
    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }
    
    public boolean getOpen() {
        return open;
    }
    
    public boolean addParticipant(String participantID) {
        if(!open || !Participant.verifyID(participantID) || breakoutRoomSize == numberOfParticipants) {
            return false;
        }
        
        // Technically, this for loop is not needed as VirtualRoom.addParticipantToBreakoutRoom() checks ALL BreakoutRoom objects for the 
        // participantID but I still included it since it specified for this function to also check for uniqueness on the paper
        for(int i = 0; i < numberOfParticipants; i++) {
            if(participantID.equals(participants[i].getParticipantID())) {
                return false;
            }
        }
        
        participants[numberOfParticipants] = new Participant(participantID);
        numberOfParticipants++;
        return true;
    }
    
    public Participant findParticipant(String participantID) {
        if(!open || numberOfParticipants == 0 || !Participant.verifyID(participantID)) {
            return null; 
        }
        
        for(int i = 0; i < numberOfParticipants; i++) {
            if(participantID.equals(participants[i].getParticipantID())) {
                return participants[i];
            }
        }            
        
        return null;
    }
    
    public String listParticipants() {
        String data = "Room ID: " + breakoutRoomID + "\n";
        
        if(numberOfParticipants == 0) {
            return data + "Empty\n";
        } else {
        
            for(int i = 0; i < numberOfParticipants; i++) {
                data += participants[i].getParticipantID() + "\n";
            } 
            
            return data;
        }
    }
    
    public String toString() {
        return breakoutRoomID + ((open) ? " OPEN " : " CLOSED ") + numberOfParticipants;
    }
    
    // Since these return void I chose to add the checks to the open and close in VirtualRoom instead
    // i.e. BreakoutRoom.closeBreakoutRoom() & BreakoutRoom.openBreakoutRoom() do not check if the room is open or closed since 
    // VirtualRoom.closeBreakoutRoom() & VirtualRoom.openBreakoutRoom() do. This prevents checking the state of the room twice.
    public void closeBreakoutRoom() {
        open = false;
        java.util.Arrays.fill(participants, null);
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom() {
        open = true;
    }    
}
