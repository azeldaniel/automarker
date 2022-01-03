package out.Ricky_Dindial_657721_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * Ricky Dindial
 * 816022023
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    private final int breakoutRoomSize;
    private static int breakoutRoomNumberCounter = 1;
   
    // Constructor
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name + breakoutRoomNumberCounter; 
        breakoutRoomNumberCounter++; 
        this.breakoutRoomSize = 10;
        this.participants = new Participant[10];
        this.numberOfParticipants = 0;
        this.open = true; 
    }
    
    
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    
    public boolean getOpen(){
        return this.open;
    }
    
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        boolean par;
        par = p.verifyID(participantID);
        if(this.numberOfParticipants == 10){
            return false;
        }
        
        if((this.open == true) && (par == true)){
            this.participants[numberOfParticipants] = p;
            this.numberOfParticipants++;
            return true;
        }
        return false;
    }
    
    
    public Participant findParticipant(String participantID){
        boolean findID;
        Participant pFind = new Participant(participantID);
        findID = pFind.verifyID(participantID);
        if(findID == true){
            for(int i = 0; i < this.numberOfParticipants; i++){
                if(this.participants[i].getParticipantID().equals(participantID)){
                    return this.participants[i];
                }
            }
        }
        return null;
    }
    
    
    public String listParticipants(){
        String information = "Breakout Room ID: " + this.breakoutRoomID + " \n";
        for(int i = 0; i < this.numberOfParticipants; i++){
            information += "Participant_"+this.participants[i].getParticipantID() + " \n ";
        }
        return information;
    }
    
    
    public String toString(){
        String state = "BreakoutRoom Number: " + breakoutRoomID + " " + this.open;
        return state;
    }
    
    
    public void closeBreakoutRoom(){
        this.open = false;
        this.participants = null;
        this.numberOfParticipants = 0;
    }
    
    
    public void openBreakoutRoom(){
        this.open = true;
    }
}
