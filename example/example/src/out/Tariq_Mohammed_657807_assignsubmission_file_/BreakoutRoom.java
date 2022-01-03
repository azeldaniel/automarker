package out.Tariq_Mohammed_657807_assignsubmission_file_;
/*
 Student ID: 816015043
 Name: Tariq Azard Mohammed
 BreakoutRoom Class
 */

public class BreakoutRoom
{
    // instance variables
    private String breakoutRoomID;
    private final int breakoutRoomSize;        // final ensures that the value of breakoutRoomSize cannot be overridden. 
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private static int breakoutRoomNumberCounter = 1;  // class variable

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];   // initialize Participant array
        numberOfParticipants = 0;
        open = false;
        breakoutRoomNumberCounter++;
    }
    
    //Accessors
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public static int getNumBreakoutRooms(){
        return breakoutRoomNumberCounter - 1;       // accessor to return the current number of breakout rooms.
    }
    
    public static void resetNumBreakoutRooms(){
        breakoutRoomNumberCounter = 1;              // resets the current number of breakout rooms (this is used when a new virtual room is created).
    }
    
    
    public void setOpen(boolean open){
        this.open = open;
    }
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);     //create new participant object
        Participant compare = findParticipant(participantID);   //used to search for duplicate participants
        
        
        // if the participant to be added is a duplicate, then output error message and return false.
        if(compare != null){
            if( p.getParticipantID().equals(compare.getParticipantID()) ){
                System.out.println("\nCannot add duplicate participant (" + p.getParticipantID() + ") to breakoutRoom\n");
                return false;
            }
        }
        
        // if the participantID is valid, not a duplicate, and the corresponding breakoutRoom is open then add the participant to the breakoutRoom.
        else if( (p.verifyID(participantID) == true ) && (this.getOpen() == true) ){
            
            //check to ensure that the number of participants will not exceed the size of the breakoutRoom
            if(getNumberOfParticipants() < this.breakoutRoomSize){
                participants[this.numberOfParticipants] = p;
                this.numberOfParticipants++;
                return true;
            }
            
            else{
                System.out.println("\nCannot add participant...The breakout room has reached its maximum capacity\n");
                return false;
            }
        }
        
        // if the participant was not added, then output according error message.
        else{
            if( (p.verifyID(participantID) == false ) ){
                System.out.println("\nAn invalid participantID was entered...\n");
            }
            
            if( (this.getOpen() == false) ){
                System.out.println("\nCould not add participant. The breakoutRoom (" + this.getBreakoutRoomID() + ") is closed...\n");
            }
        }
        
        return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant p = new Participant(participantID);
        String participant;
        
        if( (p.verifyID(participantID) == true) && (this.getOpen() == true) ){
            
            for(int i=0; i<this.breakoutRoomSize; i++){
                
                if(participants[i] != null){
                    // gets participantID from the participant array (store in String 'participant'):
                    participant = participants[i].getParticipantID();
                    
                    //check if participantID is found in the array, (if found, return the ID)
                    if(participant.equals(participantID)){
                        return participants[i];
                    }
                    
                } 
            }
        }
        
        return null;    // return null if the participantID was not found.
    }
    
    public String listParticipants(){
        String result = "";
        String participantInfo = "";
        
        result = result + "BreakoutRoom: " + getBreakoutRoomID() + "\n";
        
        /* 
          loop to iterate through the participants[] array and get the IDs of all 
          participants (appending each to a String and returning the result)  
        */ 
        for(int i=0; i<this.numberOfParticipants; i++){
            
            if(participants[i] != null){
                participantInfo = participants[i].toString();
                result = result + participantInfo + "\n";
           }
        }
        
        return result;
    }
    
    public String toString(){
        String result = "";
        String isOpen = "";
        
        if(getOpen() == true){
            isOpen = "OPEN";
        }
        else{
            isOpen = "CLOSED";
        }
        
        result = result + getBreakoutRoomID() + " " +
                 isOpen + " " + this.numberOfParticipants;
        
        
        return result;
    }
    
    public void closeBreakoutRoom(){
        setOpen(false);             // this.open = false;
        int maxVal = this.numberOfParticipants;
        
        for(int i=0; i<maxVal; i++){
            participants[i] = null;     // remove each participant from the array
            
            this.numberOfParticipants--;  /*  reduce the number of participants present 
                                              in the array accordingly */
        }
        
        
    }
    
    public void openBreakoutRoom(){
        setOpen(true);              // this.open = true;
    }
}
