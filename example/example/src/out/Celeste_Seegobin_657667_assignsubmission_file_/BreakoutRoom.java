package out.Celeste_Seegobin_657667_assignsubmission_file_;//Celeste Seegobin- 816019646
public class BreakoutRoom{
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        participants = new Participant[10];
        numberOfParticipants = 10;
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
        
    }
    
    public static int breakoutRoomNumberCounter(){
        return 0;
    }
    
    public boolean addParticipant(String participantID){
        int i=0;
        while(findParticipant(participantID) == null){
            participants[i] = new Participant (participantID); //Creating object;
            i++;
            return true;
        }
        return false;
    }
    
    
    public Participant findParticipant(String participantID){
        int loc=0;
        for(int i=0; i<numberOfParticipants; i++){
            if(participants[loc].equals(participantID)){
                return participants[loc];
            }
        }
        return null;
    }
  
    public String listParticipants(){
        String BRparticipants; 
        String details = super.toString();
        details = "BreakoutRoom" + breakoutRoomID + participants;
        for(int i=0; i<numberOfParticipants; i++){
            details = participants[i] + " ";
        }
        return "BreakoutRoom" + details;
      
    }
    
    public String toString(){
        return "Breakout Room"+breakoutRoomNumberCounter+"Breakout Room Size"+breakoutRoomSize+"Number of Participants"
                +numberOfParticipants+"Open"+open;
    }
    
    public void closeBreakoutRoom(){ //Clearing the participants data. 
        this.open = false; //Room is no longer "open"
        this.participants = null; 
        this.numberOfParticipants = 0; //There are no longer any participants in the BreakoutRoom 
        this.breakoutRoomNumberCounter = 0; 
        
        
        
    }
    
    
    public void openBreakoutRoom(){
        this.open =true;
    }
    
    //Accessors
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public Participant[] participants(){
        return participants;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    
    }
    
    public boolean getOpen(){
        return true;
    }
}
    
