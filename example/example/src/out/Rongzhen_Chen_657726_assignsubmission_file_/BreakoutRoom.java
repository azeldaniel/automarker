package out.Rongzhen_Chen_657726_assignsubmission_file_;//816014227
public class BreakoutRoom{
    
    private String breakoutRoomID;
    private int breakoutRoomNumber;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name){
        participants = new Participant[10];
        numberOfParticipants = 0;
        open = true;
        breakoutRoomNumberCounter++;
        breakoutRoomNumber = breakoutRoomNumberCounter;
        breakoutRoomID = name + breakoutRoomNumber;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getBreakoutRoomNumber(){
        return breakoutRoomNumber;
    }
    
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        
        if(p.verifyID(participantID) == true){
            if((open==true) && (numberOfParticipants <10)){
                participants[numberOfParticipants] = new Participant(participantID);
                numberOfParticipants++;
                return true;
            }
            return false;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        if(open==true){
            for(int i=0; i<numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
            return null;
        }
        return null;
    }
    
    public String listParticipants(){
        if(open==true){
            String details = breakoutRoomID + System.lineSeparator();
            
            int i = 0;
            while(i < numberOfParticipants){
                details += participants[i].getParticipantID() + System.lineSeparator();
                i++;
            }
            return details;
        }
        return "Breakout Room closed.";
    }
    
    public String toString(){
        if(open==true){
            String details = breakoutRoomID + " OPEN " + getNumberOfParticipants();
            return details;
        }
        else{
            String details = breakoutRoomID + " CLOSED ";
            return details;
        }
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        numberOfParticipants = 0;
        participants = new Participant[10];
    }

}
