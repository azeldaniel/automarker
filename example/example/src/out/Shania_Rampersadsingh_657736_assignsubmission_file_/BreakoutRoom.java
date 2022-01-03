package out.Shania_Rampersadsingh_657736_assignsubmission_file_;
/**
 * The BreakoutRoom class models a breakout room in the virtual meeting system. A breakout room
 *hosts participants. It is created by a virtual room such that the breakout room’s ID is based on the
 *virtual room’s name. Participants are added to the breakout room if it is open and if there is sufficient
 *space to accommodate new participants. Duplicate participants (based on IDs) are not allowed.
 *
 * @author Shania Rampersadsingh 816016166
 * @version (7/2/2021)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        this.breakoutRoomID = name + breakoutRoomNumberCounter++;
        //this.breakoutRoomNumberCounter;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[10];
        this.numberOfParticipants = 0;
        this.open = true;
        
    }

    /**
     * Adds a new participant (no duplicates) with a valid
     * ID to the (open) breakout room if the room is not
     * filled and then returns true, otherwise returns false
     */
    public boolean addParticipant(String participantID)
    {
        Participant newParticipant = new Participant(participantID);
        if (newParticipant.verifyID(participantID) == true){
            
            if (numberOfParticipants >= breakoutRoomSize){
                System.out.println("Breakout Room is at its maximum capacity");
                return false;
            }  
            
            else{
               participants[numberOfParticipants] = newParticipant;
        
               numberOfParticipants = numberOfParticipants + 1;
               breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
               
               return true;
            }
        }
        else{
            System.out.println("Participant ID is invalid or is a duplicate");
            return false;
        }
    }
    
    /**
     *Locates and returns a participant based on a
     *supplied (valid) ID if present in the (open) breakout
     *room, otherwise returns null.
     */
    public Participant findParticipant(String participantID){
        Participant newParticipant = new Participant(participantID);
        
        if((newParticipant.verifyID(participantID)==false) || (open == false))
        {
            return null;
        }
        
        for (int i = 0; i < numberOfParticipants; i++) {
            if(participantID.equals(participants[i].getParticipantID())){
                System.out.println(participants[i]);
                return participants[i];
            }
        }
        return null;
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
    
    
    
    /**
     * Returns a list of the participants (ID) in the breakout
     * room with the breakout room ID heading the list on
     * a separate line
     */
    public String listParticipants(){
        //code
        System.out.println("BreakoutRoom:" + this.breakoutRoomID + "\n");
        
        String participantList="";
        
        for (int i = 0; i < numberOfParticipants; i++) {
                participantList += participants[i].getParticipantID() + "\n";
        }
        return participantList;
    }
    
    /**
     * Returns a String representation of the aggregated
     * state of a BreakoutRoom
     */
    public String toString(){
        //code
        
        if(open == true){
            return breakoutRoomID + " OPEN"; 
        }
        return breakoutRoomID + " CLOSE";
       
    }
    
    /**
     * Closes the breakout room, clears the participant list
     * and resets any relevant state of the breakout room
     */
    public void closeBreakoutRoom(){
        //code
        participants = new Participant[10];
        numberOfParticipants = 0;
        open = false;
        breakoutRoomNumberCounter= 0;

        
        
    }
    
    /**
     * Opens the breakout room and sets the state as
     * open
     */
    public void openBreakoutRoom(){
        //code
        open = true;
    }
    
    public int returnBreakoutRoomNumberCounter()
    {
        return breakoutRoomNumberCounter;
    }
    
}
