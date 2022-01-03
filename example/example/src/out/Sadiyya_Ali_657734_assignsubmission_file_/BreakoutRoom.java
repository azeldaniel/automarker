package out.Sadiyya_Ali_657734_assignsubmission_file_;//816013697
public class BreakoutRoom {
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }
    
    public BreakoutRoom (String name) {
        this.breakoutRoomID = name;
        breakoutRoomNumberCounter = 0;
        breakoutRoomSize = 10;
        participants = new Participant[10];
        numberOfParticipants = 0;
        open = true;
    }
    
    public boolean addParticipant (String participantID) {
        if (open == true && numberOfParticipants < 10) {
            Participant p = new Participant(participantID);
            
            if (p.verifyID(participantID) == true) {
                participants[numberOfParticipants] = p;
                numberOfParticipants++;
                return true;
            }
        }
        return false;
    }
    
    public Participant findParticipant (String participantID) {
        Participant p = new Participant(participantID);
        
        if (open == true && p.verifyID(participantID) == true) {
            for (int i = 0; i < 10; i++) {
                if (participantID.equals(participants[i])) {
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants() {
        String participantsList = "Breakout Room ID: " +breakoutRoomID +"\n";
        
        for (int i = 0; i < numberOfParticipants; i++) {
            participantsList += participants[i] +" ";
        }
        return participantsList;
    }
    
    public String toString() {
        String breakoutRoomDetails = ("");
        breakoutRoomDetails += "Breakout Room ID: " +breakoutRoomID +"\n";
        breakoutRoomDetails += "Breakout Room Size: " +breakoutRoomSize +"\n";
        breakoutRoomDetails += "Number of Participants in Room: " +numberOfParticipants +"\n";
        breakoutRoomDetails += "Open: " +open +"\n";
        
        return breakoutRoomDetails;
    }
    
    public void closeBreakoutRoom() {
        this.open = false;
        participants = null;
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom() {
        this.open = true;
        participants = new Participant[10];
    }  
}