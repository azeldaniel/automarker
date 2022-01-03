package out.Brandon_Bissoon_657753_assignsubmission_file_;/**
 * Write a description of class BreakoutRoom here.
 *
 *Student ID :- 816022435
 *Student Name :- Brandon Bissoon 
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    public String breakoutRoomID;
    public static int breakoutRoomNumberCounter = 0;
    public static int breakoutRoomSize = 10;
    public Participant[] participants;
    public int numberOfParticipants = 0;
    public boolean open;    
   
    /*
     *Constructor� 
       */
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name){
        // initialise instance variables
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;        
    }
    
    /**
     * Accessors of the class BreakoutRoom
     */
    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }  
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getbreakoutRoomNumberCount(){
        return breakoutRoomNumberCounter;
    }
    public boolean isOpen(){
        if(this.numberOfParticipants < this.breakoutRoomSize){
            return true;
        }
        return false;
    }
    
    /*
     *Adds a new participant (no duplicates) with a valid
     *ID to the (open) breakout room if the room is not
     *filled and then returns true, otherwise returns false� 
       */
    public boolean addParticipant(String participantID){
        if(participantID == null){
            return false;
        }
        
        for(int count = 0; count < numberOfParticipants; count = count + 1 ){
            if(participants[count].getParticipantID() == participantID){
                return false;
            }            
        }
        
        if((numberOfParticipants < breakoutRoomSize) && (open == true)){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants = numberOfParticipants + 1;
            System.out.println(participantID);
            return true;
        }
        return false;
    }
    
    /*
     *Locates and returns a participant based on a
     *supplied (valid) ID if present in the (open) breakout
     *room, otherwise returns null.� 
       */
    public Participant findParticipant(String participantID){  
        int count;
        
        if((open == true) && (Participant.verifyID(participantID) == true)){
            for( count = 0; count < breakoutRoomSize; count = count + 1){
                if(participants[count].getParticipantID() == participantID){
                    return participants[count];
                }
            }
        }
        return null;
    }
   
    /*
     *Returns a list of the participants (ID and name) in
     *the breakout room with the breakout room ID
     *heading the list on a separate line� 
       */
      public String listParticipants(){
        int count;
        String phrase = " The BreakOutRoomId is :- " + breakoutRoomID;
        
        for(count = 0; count < numberOfParticipants; count = count + 1)
        {
              phrase = phrase + participants[count].toString() + "\n";
        }
        return phrase;
    }
    
    /*
     * Returns a String representation of the aggregated
     * state of a BreakoutRoom�
       */
    public String toString(){
        return ("The Room"+breakoutRoomID + " " + open + " has " + numberOfParticipants);
    }
    
    /*
     * Closes the breakout room, clears the participant list 
     * and resets any relevant state of the breakout room
       */
    public void closeBreakoutRoom(){
        System.out.println();
        open = false;
    }    
    
    /*
     * Opens the breakout room and sets the state 
     * as open
       */
    public void openBreakoutRoom(){
        System.out.println();
        open = true;
    }   
}
