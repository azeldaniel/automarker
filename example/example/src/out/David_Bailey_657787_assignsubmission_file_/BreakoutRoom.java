package out.David_Bailey_657787_assignsubmission_file_;/*References:
 * 
 */
public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant [] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        numberOfParticipants = 0;
        participants = new Participant[10];
        breakoutRoomNumberCounter++;
        open = true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public int getNumberOfParticipants(){//utilitzed in findParticipantBreakoutRoom()
        return numberOfParticipants;
    }
    public boolean addParticipant(String participantID){
        Participant newPart = new Participant(participantID);
        
        if(open && numberOfParticipants != breakoutRoomSize && newPart.verifyID(newPart.getParticipantID())){// room is not filled and id is valid
            // this for loop checks the participants array for Duplicates
            for (int i = 0; i < numberOfParticipants; i++){
            if (newPart.getParticipantID().equals(participants[i].getParticipantID()))
                return false;
        }
        
            participants[numberOfParticipants] = newPart;
            numberOfParticipants ++;
            return true;
        }
        open = false;
    return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant findPart = new Participant(participantID);
        // checks to see if ID is valid
        if(findPart.verifyID(findPart.getParticipantID()) && open){
            //iterate through participants array
            for( int i = 0; i < numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(findPart.getParticipantID())); // .equals not ==
                    return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String list = breakoutRoomID += "\n";
        String sPart;
        for ( int i = 0; i < numberOfParticipants; i++){
            sPart = participants[i].toString();
            list += sPart += "\n";
        }
        return list;
    }
    
    public String toString(){
        String details = breakoutRoomID;
        String isState;
        if (open){
            isState = "OPEN";
        }
        else{
            isState = "CLOSE";
        }
        details = details.replace("\n",""); // removes newline character from breakoutRoom ID   
        details += " " + isState + " " +  numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;// closes the breakout room
        participants = null; // clears array
        numberOfParticipants = 0; // set participants to 0
    }
    
    public void openBreakoutRoom(){
        this.open = true;
        participants = new Participant[10];
    }

}
