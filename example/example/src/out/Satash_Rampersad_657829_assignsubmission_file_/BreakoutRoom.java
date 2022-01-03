package out.Satash_Rampersad_657829_assignsubmission_file_;
/**
 * 816020134
 */

public class BreakoutRoom{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private Participant[] participants; 
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
   
    public boolean getOpen(){
        if( this.numberOfParticipants < this.breakoutRoomSize){
            return true;
        }
        return false;
    }
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
     
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public boolean addParticipant(String participantID){
        if(participantID == null){
            return false;
        }
        
        for (int i = 0; i < numberOfParticipants; i++) {
             if (participants[i].getParticipantID().equals(participantID))
                return false;  
        }
            
        if ((numberOfParticipants < breakoutRoomSize) && (open == true)){
            participants[numberOfParticipants] = new Participant(participantID);
            System.out.println(participantID);
            numberOfParticipants++;
            return true;

        }
      
        return false;
     }
    
    public Participant findParticipant(String participantID){
        if ((open == true) && (Participant.verifyID(participantID) == true)) {
        for(int i = 0; i < breakoutRoomSize; i++){
            if (participants[i].getParticipantID().equals(participantID)){           
                return participants[i];
            }

        }  
    }  
        return null;
    }
    
    public String listParticipants( ){
        String details = "Breakout room ID: " + breakoutRoomID + "\n";
        for(int i = 0; i < numberOfParticipants; i++){
              details += participants[i].toString() + "\n";
        }
        return details;
    }

    public String toString( ){
        String details;
        if (open)
            details = "OPEN";
        else
            details = "CLOSE";
        return breakoutRoomID + " " + details + " " + numberOfParticipants;
    }

    public void closeBreakoutRoom( ){
        numberOfParticipants = 0;
        open = false;
    }

    public void openBreakoutRoom( ){
        open = true;
    }

    
    public boolean getOpenBreakoutRoom( ){
        return open; 
    }
   
}
