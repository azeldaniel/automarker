package out.Amelia_Lalla_657844_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author Amelia Lalla 816021543
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    private String breakoutRoomID = null;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        participants = new Participant[10];
        numberOfParticipants = 0;
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        open = true;
    }
    
    public String getBreakoutRoomID (){
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if(this.numberOfParticipants == 10){
            return false;
        }
        if (this.open == false){
            return false;
        }
        else {
            Participant check = findParticipant(participantID);
            if(check == null){
                this.participants[numberOfParticipants] = new Participant(participantID);
                this.numberOfParticipants = this.numberOfParticipants + 1;
                return true;
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        boolean found = false;
        Participant ID;
        for (int i=0; i<numberOfParticipants; i++){
            if (this.participants[i].getParticipantID() == participantID){
                found = true;
                ID = participants[i];
                return ID;
            }
            
            if(found ==  false){
                return null;
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String details = "Breakout Room ID: " + this.breakoutRoomID + "\n";
        if (numberOfParticipants == 0){
            if(this.open == false){
                details += "Room closed, empty.";
            }
            else{
                details += "Room open, empty.";
            }
        }
        else{
            for (int i=0; i<numberOfParticipants; i++){
                details += participants[i] + "\n";
            }
        }
        return details;
    }
    
    public String toString(){
       String details = "Breakout Room ID: " + this.breakoutRoomID + "\n";
       details += "Breakout Room: " + this.breakoutRoomNumberCounter + "\n";
       details += "Breakout Room Side: " + this.breakoutRoomSize + "\n";
       details += "Number of Participants: " + this.numberOfParticipants + "\n";
       details += "Open: " + this.open;
      
       return details;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        this.participants = null;
        this.breakoutRoomNumberCounter = 0;
        this.numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
}
