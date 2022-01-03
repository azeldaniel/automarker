package out.Narin_Ramnehal_657843_assignsubmission_file_;// ID - 816015907

public class BreakoutRoom
{
    private String breakoutRoomID;
    private int numberOfParticipants;
    private Participant[] participants;
    private boolean open;
    
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    
    // Constructor
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID =  name + breakoutRoomNumberCounter;
        this.breakoutRoomNumberCounter++;
        this.numberOfParticipants = 0;
        breakoutRoomSize = 10;
        breakoutRoomNumberCounter = 1;
        getOpen();
    } 
    
    // Accessors
    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }
    
    public boolean getOpen() {
        return open;
    }

    // Methods
    public boolean addParticipant(String participantID)
    {
        Participant participant = new Participant(participantID);
        if (participant.verifyID(participantID) == true && open == true && numberOfParticipants < breakoutRoomSize) {
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        Participant participant = new Participant(participantID);
        if (participant.verifyID(participantID) == true && open == true) {
            for (int i = 0; i < numberOfParticipants; i ++ ) {
                if (participantID.equals(participants[i])) { 
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants() 
    {
        String heading = breakoutRoomID;
        for (int i = 0; i < breakoutRoomSize; i ++ ) {
            System.out.println(participants[i]);
        }
        return heading;
    }
    
    public String toString()
    {
        String details = breakoutRoomID;
        details += open + " " + numberOfParticipants;
        
        String format = breakoutRoomID + getOpen();
        return format;
    }
    
    public void closeBreakoutRoom() 
    {
        open = false;
        numberOfParticipants = 0;
        Participant[] participants = null;
    } 
    
    public void openBreakoutRoom() 
    {
        open = true;
    }
}
