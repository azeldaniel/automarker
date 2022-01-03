package out.Cameron_Sugden_657788_assignsubmission_file_;//816014699
public class BreakoutRoom{

    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
   
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[10];
        numberOfParticipants = 0;
        open = true;
    }
    
    public boolean addParticipant(String participantID){
        if(!this.open){
            System.out.println("Breakout room is closed: " + this.breakoutRoomID);
            return false;
        }
        
        else if(this.numberOfParticipants >= this.breakoutRoomSize){
            System.out.println("Breakout room is full: " + this.breakoutRoomID);
            return false;
        }
        
        if(findParticipant(participantID) != null){
            System.out.println("ID already exists in: " + this.breakoutRoomID);
            return false;
        }
        
        Participant p1 = new Participant(participantID);
        if(!p1.verifyID(participantID)){
            System.out.println("ID is invalid");
            return false;
        }
        this.participants[numberOfParticipants++] = p1;
        System.out.println(p1.getParticipantID() + "was added to the breakout room: " + this.breakoutRoomID);
        return true;
    }
    
    public Participant findParticipant(String participantID){
        if(open == true){
            for(int i=0; i<10; i++){
                if(participantID.equals(participants[i])){
                    return participants[i];
                }
            }
        }return null;
    }
    
    public String listParticipants(){
        String details = "Breakout Room ID: " + breakoutRoomID + "\n";
        for(int i=0; i<numberOfParticipants; i++){
            details += participants[i] + " ";
        }return details;
    }
    
    public String toString(){
        String toS = "";
        toS = "Breakout Room ID: " + breakoutRoomID + "\n";
        toS = "Breakout Room Size: " + breakoutRoomSize + "\n";
        toS = "Number of Participants in room: " + numberOfParticipants + "\n";
        toS = "Open: " + open + "\n";
        
    for (int i = 0; i< 10; i++){
        if(participants[i] != null){
            toS = "Participant ID: " + participants[i] + "\n";
        }
    }
        return toS;
    }
    
    public boolean getOpen(){
        return this.open;
    }
    
    public void closeBreakoutRoom(){
        if(open == true){
            open = false;
            for(int i=0; i<numberOfParticipants; i++){
                participants[i] = null;
            }
            numberOfParticipants = 0;
        }
    }
    
    public void openBreakoutRoom(){
        this.open = true;
        participants = new Participant[10];
    }  
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;  
    }
}