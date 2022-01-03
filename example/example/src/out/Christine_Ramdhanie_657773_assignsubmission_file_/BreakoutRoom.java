package out.Christine_Ramdhanie_657773_assignsubmission_file_;//ID: 816018588
//NAME: CHRISTINE RAMDHANIE
//COMP 2603 - ASSIGNMENT 1

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize ;
    private Participant[ ] participants;
    private int numberOfParticipants;
    private boolean open ; 
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant [10];
        numberOfParticipants = 0;
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
    }
    
    //Accessors or getters
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public static int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public final int getbreakoutRoomSize(){
        return breakoutRoomSize;
    }
    

    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen (){
        return open;
    }
    
    //Methods 
    public boolean addParticipant( String participantID) {
        int count=0; 
        
        while (findParticipant(participantID) == null){
           participants[count] = new Participant (participantID);
           count++;
           return true;
        }
        return false;
    }
    
    public Participant findParticipant( String participantID){
        int count = 0;
        boolean helper=false;
        while (numberOfParticipants >count){
            if(participants[count].equals(participantID)){ 
                helper = true;
                break;                     
        }
        else 
        count++;
       }
       if (helper= true)
       return participants[count];
       else
       return null;
    }
    
    public String listParticipants( ){
        String participantsInBreakRoom = " ";
        String details = "BreakRoom ID: " + getBreakoutRoomID() + "\r\n";
        int count = 0;
        while (getNumberOfParticipants() > count){
            participantsInBreakRoom= participants[count].getParticipantID() + "_" + count + "\n" ;
            count++;
        }
        return details + participantsInBreakRoom;
    }
    
    public String toString(){
        String breakRoomDetails;
        String participantDetails;
        String sizeDetails;
        String numParticipants;
        String state;
        breakRoomDetails = "Breakout Room ID: " + getBreakoutRoomID() + "\r\n";
        sizeDetails = "Breakout Room Size: " + getbreakoutRoomSize() + "\r\n";
        participantDetails= "Participants: " + listParticipants() + "\r\n";
        numParticipants = "Number of Participants: " + getNumberOfParticipants() + "\r\n";
        state = getBreakoutRoomID() + "State: " +getOpen();
        return breakRoomDetails + sizeDetails + participantDetails + numParticipants + state;
    } 
    
    public void closeBreakoutRoom(){
        this.participants = null;
        this.open = false;
        this.breakoutRoomNumberCounter = 0;
        this.numberOfParticipants= 0;
    }
    
     public void openBreakoutRoom(){
       open = true;
       this.open = open;
    }
}
