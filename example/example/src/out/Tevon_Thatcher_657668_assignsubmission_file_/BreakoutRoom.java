package out.Tevon_Thatcher_657668_assignsubmission_file_;/**
 * @Tevon Thatcher - 816019492
 */

public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        breakoutRoomID=name+breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        breakoutRoomSize=10;
        participants = new Participant[10];
        numberOfParticipants=0;
        open=false;
    }

    
    public boolean addParticipant(String participantID)
    {
        Participant tempParticipant = new Participant(participantID);
         
        if(tempParticipant.verifyID(participantID) && open && numberOfParticipants < breakoutRoomSize){
            participants[numberOfParticipants]=new Participant(participantID);
            numberOfParticipants++;
            return true;
        } 
        else{
            return false;
        }
    }
    
    public Participant findParticipant(String participantID){
        for(int i=0;i<breakoutRoomSize;i++){  
            if(participants[i] != null && participantID.equals(participants[i].getParticipantID())){
                return participants[i];
            }
        }
        
        return null;
    }
    
    public String listParticipants(){
        String returnList = breakoutRoomID + "\n";
        for(int i=0;i<breakoutRoomSize;i++){
            if(participants[i] == null)
                continue;
                
            returnList += participants[i] + "\n";
        }
        return returnList;
    }
    
    public String toString(){
        String returnString = "Breakout Room ID:" + breakoutRoomID + " ";
        
        if(open){
            returnString += "Open";
        }
        else{
            returnString += "Closed";
        }
        return returnString;
    }
    
    public void closeBreakoutRoom(){
        open=false;
    }
    
    public void openBreakoutRoom(){
        open=true;
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
}

