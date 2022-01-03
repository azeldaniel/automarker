package out.Jamal_Ali_657686_assignsubmission_file_;
/**
 * BreakoutRoom Class
 * The BreakoutRoom class models a breakout room in the virtual meeting system. A breakout room hosts participants.
 * Jamal Ali
 * ID: 816014616
 */
public class BreakoutRoom
{
    // instance variables 
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }

    /**
     Methods for BreakoutRoom Class
     */
    public boolean addParticipant (String participantID)
    {
        // put your code here
        if(open && (numberOfParticipants < breakoutRoomSize)){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
        }
        System.out.println("Failed to Add");
        return false;
    }
    
    public Participant findParticipant(String participantID){
        if(open){
            for (int i=0; i<numberOfParticipants;i++){
                if(participantID.equals(participants[i])){
                    return participants[i];
                }
            }
         }
         return null;
    }
    
    public String listParticipants(){
        String BreakoutRoomDetails = "All Participants in Room " +breakoutRoomID + " : \n";
        for(int i=0; i<numberOfParticipants; i++){
            BreakoutRoomDetails += participants[i] + "\n";
    }
    return BreakoutRoomDetails;
    }
    
    public String toString(){
        String state;
        if(open){
            state = "Open";
        }
        else{ state = "Closed";
        }
        return (breakoutRoomID +" " + state + "\nRoom Size :" + 
        breakoutRoomSize + "\n Participants in Room : " + numberOfParticipants 
        +  "\n\n\n" );
    }
    
    public void closeBreakoutRoom(){
        open = false;
        for (int i=0; i<breakoutRoomSize;i++){
            participants[i]=null;
        }
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    
}
