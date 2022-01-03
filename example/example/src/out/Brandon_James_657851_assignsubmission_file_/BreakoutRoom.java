package out.Brandon_James_657851_assignsubmission_file_;
/**
 *
 * @815006970 (ID)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private Participant[] participants = new Participant[10];
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private int numberOfParticipants = 0;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        open = true;
    }
    
    //Accessors
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getNumberOfParticipants(){
        return numberOfParticipants+1;
    }
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID)
    {   
        if(findParticipant(participantID)!=null){
            System.out.println("Participant already in room.");
            return false;
        } //no duplicates
        if(open==false){
            System.out.println("Room is closed. Cannot add participant.");
            return false;
        }
        if(numberOfParticipants == breakoutRoomSize){
            System.out.println("Room is full. Cannot add participant.");
            return false;
        }
        
        Participant temp = new Participant(participantID);
        if(temp.verifyID(participantID)){
           participants[numberOfParticipants] = temp;
           numberOfParticipants++;
           return true;
        }else {
           System.out.println("participantID format not valid.");
           return false;
        }
    }
    
    public Participant findParticipant(String participantID){
        if(open==false){
            System.out.println("Room closed.");
            return null;
        }
        Participant tempP = new Participant(participantID);
        if(tempP.verifyID(participantID)){
           for(int i=0; i<numberOfParticipants; i++){
               if(participantID == participants[i].getParticipantID()){
                   return participants[i];
                }
            }
        }else {
           System.out.println("participantID not found.");
        }
        return null;
    }
    
    public String listParticipants(){
        if(open==false){
            return "Room closed. No participants.";
        }
        String newline = "\n";
        String list = newline +"BreakoutRoomID: "+breakoutRoomID +newline;
        for(int j=0; j<numberOfParticipants; j++){
            list += participants[j].toString();
        }
        return list;
    }
    
    public String toString(){
        String isOpen;
        if(open==true){
            isOpen = "OPEN";
        }else {
            isOpen = "CLOSED";
        }
        
        String roomState = breakoutRoomID + isOpen + getNumberOfParticipants();
        return roomState;
    }
    
    public void closeBreakoutRoom(){
        participants = null;
        open = false;
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
}
/* Sources:
 * https://www.techiedelight.com/print-newline-java/
 * 
 */
