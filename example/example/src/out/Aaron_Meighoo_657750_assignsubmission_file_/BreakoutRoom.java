package out.Aaron_Meighoo_657750_assignsubmission_file_;//Aaron Meighoo
//816000303
//A1
//BreakoutRoom Class

public class BreakoutRoom{
    
    private String breakoutRoomID = null;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants; 
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String roomName){
        breakoutRoomID = roomName + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[10];
        numberOfParticipants = 0;
        this.open = true;
        breakoutRoomNumberCounter++;
    
    
    }

    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    
    
    public boolean getOpen(){
        return open;
    }
    
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public Participant[] getParticipants(){
        return participants;
    }
   
    
    public boolean addParticipant(String participantID){
        if(getNumberOfParticipants() == 10)
            return false;
        if(getOpen() == false)
            return false;
        else{
            Participant p = findParticipant(participantID);
            if(p == null){
                participants[numberOfParticipants] = new Participant(participantID);
                this.numberOfParticipants++;
                return true;
                }   
            }
            return false;
        }
    
    public Participant findParticipant(String participantID){
        boolean check = false;
        for(int i = 0; i < getNumberOfParticipants(); i++){
            if(participants[i].getParticipantID().equals(participantID))
                return participants[i];
            else
                check = false;
        }
        return null;
    }
        
    public String listParticipants(){
        String breakoutRoomParticipants = "";
        breakoutRoomParticipants = "BreakoutRoom ID: " + getBreakoutRoomID() + "\n";
        for(int i = 0; i< getNumberOfParticipants(); i++){
            breakoutRoomParticipants += participants[i] + "\n";
        }
        return breakoutRoomParticipants;
        
    }
    
    public String toString(){
        String details;
        details = "BreakoutRoom ID: " + getBreakoutRoomID() + "\n";
        details += "Participants" + listParticipants();
        details += "BreakoutRoom Size: " + getBreakoutRoomSize() + "\n";
        details += "Number of Participants: " +getNumberOfParticipants() + "\n";
        details += "Open: " + getOpen();
        return details;
        
    
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    public void closeBreakoutRoom(){
        this.breakoutRoomNumberCounter = 0;
        this.open = false;
        this.participants = null;
        this.numberOfParticipants = 0;
    }
    
    public static void main(String [] args){
        String name = "Biology";
        String details = "10101010";
        BreakoutRoom b1 = new BreakoutRoom(name);
        boolean ch = b1.addParticipant(details);
        System.out.println(ch);
        System.out.println(b1.findParticipant(details));
        String p = b1.listParticipants();
        System.out.println(p);
        String det = b1.toString();
        System.out.println(det);
    }
}

    
    















