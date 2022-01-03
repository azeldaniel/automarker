package out.Adrian_Khan_657741_assignsubmission_file_;
/*
 * StudentID: 816020488
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomID = name + breakoutRoomNumberCounter;        
        breakoutRoomNumberCounter++;
        final int breakoutRoomSize = 10;
        participants = new Participant[10]; 
        numberOfParticipants = 0;
        this.open = true;
    }

    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }    
    
    public boolean getOpen()
    {
        return open;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean addParticipant(String participantID)
    {
        //verify the participantID
        if(Participant.verifyID(participantID) != true){
            //System.out.println("Cannot add, invalid participantID!");
            return false;
        }
        if(this.open != true){
            //System.out.println("Cannot add, room is closed!");
            return false;
        }
        if(findParticipant(participantID) != null){
            //System.out.println("Cannot add, participantID is null!");
            return false;
        }
        if(numberOfParticipants >= 10){
            //System.out.println("Cannot add, exceeds number of participants!");
            return false;
        } else {
            participants[numberOfParticipants] = new Participant(participantID);
            //System.out.println("Participant added!");
            numberOfParticipants += 1;
        }
        return true;
    }
    
    public Participant findParticipant(String participantID)
    {
        if(Participant.verifyID(participantID) != true){
            //System.out.println("Cannot find an invalid participandID!");
            return null;
        }
        if(this.open != true){
            //System.out.println("Cannot find participantID in a closed BreakoutRoom!");
            return null;
        }
        for (int i = 0; i < numberOfParticipants; i++){
            if(participants[i].getParticipantID().equals(participantID)){
                //System.out.println(participantID + " found!");
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants()
    {
        String details = "";
        for(int i = 0; i < numberOfParticipants; i++){
            details += participants[i].toString() + " ";
        }
        return "BreakoutRoomID: " + breakoutRoomID + "\n" + details;
    }
    
    public String toString()
    {
        String details = " ";
        
        if(open == true){
            details = breakoutRoomID + " OPEN " + numberOfParticipants + " ";
        }
        
        if(open == false){
            details = breakoutRoomID + " CLOSED " + numberOfParticipants + " ";
        }        
        
        return details;
    }
    
    public void closeBreakoutRoom()
    {
        open = false;
        for (int i = 0; i < numberOfParticipants; i++){
            participants[i] = null;
        }
        numberOfParticipants = 0;
        //System.out.println("Closed BreakoutRoom " + breakoutRoomID);
    }
    
    public void openBreakoutRoom()
    {
        open = true;
        //System.out.println("Opened BreakoutRoom " + breakoutRoomID);
    }    
    /* Sources:
     * https://www.w3schools.com/java/java_class_methods.asp
     */
}
