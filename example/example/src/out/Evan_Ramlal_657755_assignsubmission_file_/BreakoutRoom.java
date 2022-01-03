package out.Evan_Ramlal_657755_assignsubmission_file_;
/**
 *
 * Evan Ramlal
 * 813117763
 
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private final String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10; // num of participants
    private final Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        this.participants = new Participant[10];
        this.numberOfParticipants = 0;
        this.breakoutRoomID = name + breakoutRoomNumberCounter++; // todo check for this int to string cast
        this.open = true;
    }

    public boolean getOpen(){
        return this.open; 
    }

    public String getBreakoutRoomID(){ 
        return breakoutRoomID; 
    }

    public int getNumberOfParticipants(){ 
        return numberOfParticipants; 
    }

    /*
        check for:
        - participant is not a duplicate
        - partid is valid 
        - room is open 
        - room is full 
     */
    public boolean addParticipant(String participantID){
        if (!this.open){ // is the room closed or full?
            System.out.println("Room: " + this.breakoutRoomID + " is CLOSED!"); 
            return false;
        }else if (this.numberOfParticipants >= this.breakoutRoomSize){ // is the room closed or full?
            System.out.println("Room:" + this.breakoutRoomID + "is FULL!"); 
            return false;
        }
        if (findParticipant(participantID) != null) { // is the person already in the room?
            return false;
        }
        Participant p1 = new Participant(participantID);
        if(!p1.verifyID(participantID)){
            return false;
        }
        this.participants[numberOfParticipants++] = p1;
        System.out.println(participantID + " added to " + breakoutRoomID ); 
        return true;
    }
    
    public Participant findParticipant(String participantID){
        if (!this.open){ // is the room open?
            System.out.println("Room: "+breakoutRoomID + " is CLOSED!"); 
            return null;
        }
        for (int i = 0; i < this.numberOfParticipants; i++) {
            if (this.participants[i].getParticipantID().equals(participantID)){ // is this person already in the room?
                System.out.println("Person: " + participantID + " is already in!"); 
                return this.participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String val = breakoutRoomID + "\n";
        for (int i = 0; i < this.numberOfParticipants; i++) {
            val += this.participants[i].toString() + "\n";
        }
        return val;
    }
    
    public String toString(){
        String temp1 = "OPEN";
        if (!this.open){
            temp1 = "CLOSE";
        }
        return this.breakoutRoomID + " " + temp1 + " " + this.numberOfParticipants + " ";
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        for(int i = 0; i < this.numberOfParticipants; i++){
            this.participants[i].equals(null);
        }
        this.numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }

    private static void tester(){
        BreakoutRoom b1 = new BreakoutRoom("COMP");
        // test for open room
        b1.openBreakoutRoom();
        b1.addParticipant("12345678");
        b1.addParticipant("12345678");
        b1.addParticipant("12345673");
        b1.addParticipant("12345673");
        b1.addParticipant("abd");
        System.out.println(b1.toString());
        System.out.println(b1.listParticipants());
        // test for closed room
        b1.closeBreakoutRoom();
        b1.addParticipant("12545673");
        b1.findParticipant("12545673");
        System.out.println(b1.listParticipants());
        System.out.println(b1.toString());
    }

    public static void main(String args[]){
         //tester();
    }

}
