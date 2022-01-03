package out.Chelsie_Rochford_657728_assignsubmission_file_;/**
 *816000366
 */
import java.io.*;
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
        // initialise instance variables
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberofParticipants(){
        return numberOfParticipants;
    }

    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if(this.open && numberOfParticipants < breakoutRoomSize && findParticipant(participantID)==null){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
        }
        return false;
    }
   
    
    public Participant findParticipant(String participantID){
        for(int i=0; i<numberOfParticipants; i++){
            if(participantID.equals(participants[i].getParticipantID())){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String list="";
        for (int i=0; i<numberOfParticipants; i++){
            list += participants[i].toString();
            list += "\n";
        }
        return list;
    }
    
    
    public String toString(){ 
        String state;
        if (this.open) state = " OPEN ";
        else state = " CLOSED ";
        state += numberOfParticipants;
        return state;
    }
    
    public void closeBreakoutRoom(){
        if (this.open) this.open = false;   
        for (int i=0; i<numberOfParticipants; i++)
            participants[i]=null;
        numberOfParticipants = 0;
    }
    
    
    public void openBreakoutRoom(){
        if (!this.open) this.open = true;
    }
    
    
}
