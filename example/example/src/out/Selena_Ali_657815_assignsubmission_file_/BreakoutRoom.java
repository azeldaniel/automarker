package out.Selena_Ali_657815_assignsubmission_file_;// 816017254
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomID= name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        breakoutRoomSize= 10;
        participants = new Participant[10];
        numberOfParticipants= 0;
        open= true;
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
    
    public boolean addParticipant (String participantID){
        if (Participant.verifyID(participantID) == true){
            if (breakoutRoomSize <= 10){
                numberOfParticipants++;
                return true;
            }
        }
        
        return false;
    }
    
    public Participant findParticipant (String participantID){
        for (int i= 0; i<numberOfParticipants; i++){
            if(participants[i].getParticipantID().equals(participantID)){
                return participants[i];
            }
        }
        
        return null;
    }
    
    public String listParticipants(){
        String output;
        
        output=  getBreakoutRoomID() + "\n";
        
        for (int i=0; i<numberOfParticipants; i++){
            output= output + " " + participants[i].getParticipantID();
        }
        
        return output;
    }
    
    public String toString(){
        String br= "Breakout Room ID: " + getBreakoutRoomID();
        
        if (open == true)
            br+= " Open ";
        
        else
            br+= " Close ";
        
        br+= "Number of Participants: " + numberOfParticipants;
             
        return br;
    }
    
    public void closeBreakoutRoom(){
        open= false;
        participants= null;
        numberOfParticipants= 0;
        breakoutRoomNumberCounter--;
    }
    
    public void openBreakoutRoom(){
        open= true;
    }
}
