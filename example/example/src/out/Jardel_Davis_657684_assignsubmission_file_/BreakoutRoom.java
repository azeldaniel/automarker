package out.Jardel_Davis_657684_assignsubmission_file_;
//816017045
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        participants = new Participant[breakoutRoomSize];
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + " " + breakoutRoomNumberCounter;
        numberOfParticipants = 0;
        open = true;
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if(numberOfParticipants == 10){
            return false;
        }
        participants[numberOfParticipants] = new Participant(participantID);
        if(participants[numberOfParticipants].verifyID(participantID) == true && open == true){
            numberOfParticipants++;
            return true;
        }
        
        return false;
        
    }
    
    public Participant findParticipant(String participantID){
        for(int i = 0 ; i<10 ; i++){
            if ((participants[i].getParticipantID()).equals(participantID)){
                return participants[i];
            }
        }
        return null;
}
    
    public String listParticipants(){
        String details = breakoutRoomID + "\n";
        for (int i = 0 ; i< numberOfParticipants; i++){
            details+= participants[i].toString() + "\n";
        
        }
        return details;
    }
    
    public String toString(){
        if(open == true)
        return breakoutRoomID + " OPEN, Number of Participants: " + numberOfParticipants + "\n";
        
        return breakoutRoomID + " CLOSE " + numberOfParticipants + "\n";
    }
    
    public void closeBreakoutRoom(){
        if (open == true){
            for(int i = 0; i<breakoutRoomSize; i++){
                participants[i] = null;
            }
            numberOfParticipants = 0;
            open = false;
        } 
    }
    
    public void openBreakoutRoom(){
        if (open == false)
            open = true;
       
    }
    
}
