package out.Aaliya_Khan_657715_assignsubmission_file_;
/**
 * Student ID - 816019696
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants = new Participant[100];
    private int numberOfParticipants;
    private boolean open;
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public BreakoutRoom(String name){
        this.breakoutRoomID = name + breakoutRoomNumberCounter; 
        this.breakoutRoomNumberCounter++;
        this.open = true;
        this.breakoutRoomSize = 10;
    }
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        boolean verification = p.verifyID(participantID);
        
        if(verification == true){
            if(numberOfParticipants < 10){
                participants[numberOfParticipants] = p; //idk
                numberOfParticipants++;
                return true;
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant p = new Participant(participantID);
        boolean verification = p.verifyID(participantID);
        
        if(verification == true){
            for(int i = 0; i < getNumberOfParticipants(); i++){
                if(this.participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String list;
        
        list = getBreakoutRoomID();
        list += "\r\n";
        
        for(int i = 0; i < getNumberOfParticipants(); i++){
            list += participants[i].getParticipantID();
            list += "\n";
        }
        
        return list;
    }
    
    public String toString(){
        String state;
        
        state = breakoutRoomID;
        state += " ";
        
        if(numberOfParticipants == 10){
            this.open = false;
        }
        
        if(this.open == true){
            state += "OPEN ";
            state += "\r\n";
        }
        else {
            state += "CLOSED";
            state += "\r\n";
        }
        
        state += "Number of Participants - ";
        state += getNumberOfParticipants();
        state += "\r\n";
        
        return state;
    }
    
    public void closeBreakoutRoom(){
        if(this.open == true){
            this.open = false;
        
            for(int i = 0; i < getNumberOfParticipants(); i++){
                this.participants[i] = null;
            }
        
            this.numberOfParticipants = 0;
        }
        else {
            System.out.println("Breakout room is already closed.");
            System.out.println();
        }
               
    }
    
    public void openBreakoutRoom(){
        if(this.open == false){
            this.open = true;
        }
        else {
            System.out.println("Breakout room was already opened.");
        }        
    }
    
}
