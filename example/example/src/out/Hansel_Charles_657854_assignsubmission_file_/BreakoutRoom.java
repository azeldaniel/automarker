package out.Hansel_Charles_657854_assignsubmission_file_;
/*
 * HANSEL CHARLES
 * ID: 816011166
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant [] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize = 10;
        this.numberOfParticipants = 0;
        this.open = true;
        this.participants = new Participant[breakoutRoomSize];
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
        Participant ps = new Participant(participantID);
        /*String ID = ps.getParticipantID();
        && !ID.equals(participantID)*/
        
        if((numberOfParticipants < breakoutRoomSize) && (ps.verifyID(participantID))){ 
            participants[numberOfParticipants] = ps;

            numberOfParticipants++;
            return true;
        }    
        return false;   
    }
    
    public Participant findParticipant(String participantID){
        
        for(int i=0; i< getNumberOfParticipants(); i++){
            if(participants[i].getParticipantID().equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
   
        if(getNumberOfParticipants() == 0){
            String details = "";
            details += breakoutRoomID;
            details +="\n" + "No Participants";
            
            return details;
        }else{
            String details = "";
            details += breakoutRoomID; 
            for(int i=0; i< getNumberOfParticipants(); i++){
                
                details += "\n"+ participants[i].toString();
            }
            
            return details;
        }
        
    }

    public String toString(){
        String details = breakoutRoomID ;
        
        if (open){ 
            details += "_OPEN_";
        }else{
            details += "_CLOSED_";
        }
        details += getNumberOfParticipants();
        
        return details;
    }
    
    public void closeBreakoutRoom(){
        if(getOpen()){
            this.breakoutRoomNumberCounter=0;
            this.numberOfParticipants = 0;
            this.open = false;
            this.participants = new Participant[breakoutRoomSize];
        }
    }
    
    public void openBreakoutRoom(){
        if(!getOpen()){
            this.open = true;
        }
    }
    
}

 
