package out.Jean___Paul_Lezama_657809_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String name;
    private String state;
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        this.breakoutRoomNumberCounter++;
    
        this.name = name;
        this.breakoutRoomID = name+ " "+breakoutRoomNumberCounter;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0;
        this.open = true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean addParticipant(String participantID)
    {
        // put your code here
        Participant p = new Participant(participantID);
        if(p.verifyID(participantID)&& open){
              for(int i = 0; i<50;i++){
                if(participants[i].equals(participantID)){
                return false;
                }
              }
        }
              participants[numberOfParticipants] = p;
              numberOfParticipants = numberOfParticipants + 1;
        
        return true;
    
    }

    
    public Participant findParticipant (String participantID){
        for(int i = 0; i<numberOfParticipants;i++){
            if((participants[i].getParticipantID()).equals(participantID)){
                return participants[i];
            }
        }
       
        return null;
    }
    
    public String listParticipants(){
        String list = "Room ID: " +breakoutRoomID+ '\n' +"Participants: " +'\n';
        for(int i = 0; i<numberOfParticipants;i++){
            list += " " +participants[i].toString()+ '\n'; 
            }
        return list;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    public String toString(){
        if(open == true)
            state = "OPEN";
            
        if(open == false)
            state = "CLOSED";
    return ""+breakoutRoomID+ " " +state+ " "+numberOfParticipants;
    }
    
    public String setID(){
        return breakoutRoomID;
    }
    
    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean stateOpen(){
        return this.open;
    }
}
