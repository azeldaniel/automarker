package out.Bria_Paul_657710_assignsubmission_file_;
/**
 * 816018930
 * @author BriaPaul
 * 
 * A breakout room hosts participants. 
 * It is created by a virtual room such that the breakout room’s ID is based on the virtual room’s name
 * Duplicate participants (based on IDs) are not allowed.
 *
 * @version 30/01/2021
 */

public class BreakoutRoom{
    // instance variables 
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    

    /** Constructor for objects of class BreakoutRoom **/
    public BreakoutRoom(String name){
        // initialise instance variables
        this.breakoutRoomNumberCounter+=1;
        this.breakoutRoomID=String.valueOf(breakoutRoomNumberCounter);
        this.breakoutRoomSize=10;
        this.numberOfParticipants=0;
        this.participants = new Participant[breakoutRoomSize];
    }
    
    /**  accessor for room ID */
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    /**  Adds a new participant (no duplicates) with a valid ID to the (open) breakout room if the room is not
      filled and then returns true, otherwise returns false */

    public boolean addParticipant( String participantID){
        Participant newParticipant = new Participant(participantID);
        
        String ID=newParticipant.getParticipantID();
        
        Boolean valid = newParticipant.verifyID(ID);
        
        if(this.numberOfParticipants == 10){
            System.out.println("Breakout Room is FULL !!");
            return false;
        }
        
        if( (valid == true) && (open==true) ) {
            participants[numberOfParticipants]=newParticipant;
            this.numberOfParticipants+=1;
            return true;
        }
    
        return false;
    }
    
    
    /** Locates and returns a participant based on a supplied (valid) ID if present in the (open) breakout room, 
     * otherwise returns null.*/
     
    public Participant findParticipant( String participantID){
        Participant findParticipant = new Participant (participantID);
        boolean valid = findParticipant.verifyID(participantID);
        
        if ((valid == true) && (open == true)){
        for(int i=0; i<numberOfParticipants; i++){ 
            if(this.participants[i].getParticipantID().equals( participantID))
               return participants[i];
        }
       }
        
        if(valid == false){
          System.out.println("ID is not valid!");
       }
        
       if(open == false){
        System.out.println("Breakout room is closed! There are no participants present.");
       }
      
      return null;
        
    }
    
    /** Returns a list of the participants (ID ) in the breakout room with the breakout room ID
     * heading the list on a separate line */
    
     public String listParticipants( ){
         String ParticipantList="";
         ParticipantList = ("RoomID: " + breakoutRoomID + "\n");
        
         for(int i=0; i<numberOfParticipants; i++){
            ParticipantList += participants[i].getParticipantID() + "\n";
         }
        
         return ParticipantList;
    }

    /** Returns a String representaation of the aggregated state of a BreakoutRoom  */

    public String toString(){
        String breakOutRoomState;
        
        breakOutRoomState =("Room ID: " + breakoutRoomID + "  ");
        
        if(open == true){
         breakOutRoomState += ("Open: OPEN \n");
        }
        else
           breakOutRoomState += ("Open: CLOSE \n");
           
        breakOutRoomState += ("Number of Participants: " + numberOfParticipants + "\n");
        
        return breakOutRoomState;
    }
    
    /** Closes the breakout room, clears the participant list and resets any relevant state of the breakout room */
    
    public void closeBreakoutRoom(){
         this.open = false;
         this.participants=null;
         this.numberOfParticipants=0;
    }
    
    /** Opens the breakout room and sets the state as open */
    
    public void openBreakoutRoom(){
         this.open = true;
    }
    
    /**  accessor for state of room whether open or close */
    public boolean getOpen(){
        return this.open;
    }
    
    /**  accessor for number of participants */
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
}
