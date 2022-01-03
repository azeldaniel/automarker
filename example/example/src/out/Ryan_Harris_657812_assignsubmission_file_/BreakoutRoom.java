package out.Ryan_Harris_657812_assignsubmission_file_;/*
 * 
 * ID: 816021062
 * Name: Ryan Harris
 * 
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private final int breakoutRoomSize;
    private Participant[] participants = new Participant[10];
    private Participant test;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        //System.out.println("Breakroom: " + breakoutRoomID);
        breakoutRoomNumberCounter++;
        breakoutRoomSize=10;
        numberOfParticipants=0;
        open = true;
    }
    
    public boolean addParticipant(String participantID){
        if (!open) return false;
        test= new Participant(participantID);
        //System.out.println("Participant " + participantID    + " in breakout room " + breakoutRoomID);
        if (!test.verifyID()) return false; 
        
        if (numberOfParticipants == breakoutRoomSize){ 
                            System.out.println("full " + numberOfParticipants);
                            return false;}
        if (numberOfParticipants == 0){
            participants[0]= new Participant(participantID);
            numberOfParticipants = 1;
            return true;
        }
        for (int i=0; i<numberOfParticipants ; i++){
            if (participantID.equals(participants[i].getParticipantID())){
                return false;
            }
        }
        
        participants[numberOfParticipants]= new Participant(participantID);
        //System.out.println("Participant " + participants[numberOfParticipants] + " in breakout room " + breakoutRoomID);
        numberOfParticipants++;
        return true;
    }
    
    public Participant findParticipant(String participantID){
        test= new Participant(participantID);
        if (!test.verifyID()) return null;
        
        for (int i=0; i<numberOfParticipants ; i++){
            if (participantID.equals(participants[i].getParticipantID())){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String str = "Participants: \n  ";
        if (numberOfParticipants == 0) str += "Empty Room";
        for (int i=0; i<numberOfParticipants ; i++){
            str += participants[i].toString() + "\n  ";
        }
        return str;
    }
    
    public String toString(){
        String str = "Breakout Room ID: " + breakoutRoomID + "\n";
        str+="Is Room Open: " + open + "\n";
        str+= "Number of Participants: " + numberOfParticipants + "\n\n";
        return str;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        numberOfParticipants = 0;
        for (int i=0; i<numberOfParticipants ; i++){
            participants[i]=null;
        }
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public int getBreakoutRoomCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public boolean testID(String participantID){
        Participant test = new Participant(participantID);
        return test.verifyID(participantID);
    }
}
