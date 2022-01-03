package out.Daniel_Herbert_657791_assignsubmission_file_;//816021155
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10; 
    private Participant[] participants = new Participant[breakoutRoomSize];
    private int numberOfParticipants = 0;
    private boolean open = true;
    private boolean check;
    
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
    }
    
    public boolean addParticipant( String participantID)
    {
        /* Figure out this isn't working :(
        for(int i = 0; i < participants.length; i++){
            for(int j = i + 1; j < participants.length; j++){
                if(participants[i].equals(participants[j])){
                    //System.out.println("Duplicate : "+participants[j]);
                    check = true;
                }
            }
        }
        */
        if(open == true && Participant.verifyID(participantID) == true && check != true){
            if(numberOfParticipants == breakoutRoomSize)
                return false;
            numberOfParticipants++;
            participants[numberOfParticipants] = new Participant(participantID);
            return true;
        }
        
        return false;
    }
    
    public Participant findParticipant(String participantID){
        for(int i = 0; i <= numberOfParticipants; i++){
            if(open == true && Participant.verifyID(participantID) == true){
                String currentID = participants[i].getParticipantID();
                if(currentID.equals(participantID))
                    return participants[i];
            }
        }
        
        return null;
    }
    
    public String listParticipants(){
        String details = "Breakout Room: " + breakoutRoomID + "\n";
        for(int i = 0; i <= numberOfParticipants; i++){
            //System.out.println("Breakout Room: " + breakoutRoomID);
            //System.out.println(participants[i].toString());
            details += participants[i].toString() + "\n";
        }
        
        return details;
    }
    
    public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public String toString(){
        return "Seminar" + breakoutRoomNumberCounter + " OPEN " + numberOfParticipants;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        this.numberOfParticipants = -1;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
}
