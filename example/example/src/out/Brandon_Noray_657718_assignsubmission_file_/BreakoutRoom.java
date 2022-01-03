package out.Brandon_Noray_657718_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (816018360 | Brandon Noray)
 * @version (v1.6.9)
 */
public class BreakoutRoom
{
    /** Variables **/
    private String breakoutRoomID;
    //public int breakoutRoomNumberCounter;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
   
    //public int counter = 0;//Check this

    /** Constructor **/
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomNumberCounter++;
        //this.counter = breakoutRoomNumberCounter;
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[this.breakoutRoomSize];
        this.numberOfParticipants = 0;
        this.open = false;
        //System.out.println("Created Breakroom " + breakoutRoomNumberCounter);
    }
    /** Accessor **/
    public String getBreakoutRoomID()
    {
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants()
    {
        return this.numberOfParticipants;
    }
    
    public boolean getOpen()
    {
        return this.open;
    }

    /** Methods **/
    public boolean addParticipant(String participantID)
    {
        // put your code here
        //Participant participant = new Participant(participantID);
        if( getOpen() && //Room Open
            getNumberOfParticipants() < this.breakoutRoomSize && //Not filled
            findParticipant(participantID) == null && //Not already in list
            Participant.verifyID(participantID) //Valid ID
        ){
            this.participants[this.numberOfParticipants] = new Participant(participantID);
            this.numberOfParticipants++;
            //System.out.println("Added");
            return true;
        }
        
        //System.out.println("Failed");
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        // put your code here
        //System.out.println("Looking for: " + participantID);
        if(getOpen()){
            for(int i=0; i < getNumberOfParticipants(); i++)
            {
                String find = this.participants[i].getParticipantID();
                if(find == participantID){
                    //System.out.println("found");
                    return this.participants[i];
                }
            } 
        }

        return null;
    }
    
    public String listParticipants()
    {
        // put your code here
        String list = "";
        list += this.toString() + "\n";
        list += "===========" + "\n";
        for(int i=0; i<this.numberOfParticipants; i++){
            //System.out.println(this.participants[i].getParticipantID());
            list += this.participants[i].toString() + "\n";
        }
        list += "\n";
        
        return list;
    }
    
    public String toString()
    {
        //System.out.println("open: " + this.open);
        //String state = " [OPEN |" + this.numberOfParticipants + "]";
        //if(!this.open) state = " [CLOSED |" + this.numberOfParticipants + "]";
        String state = " OPEN ";
        if(!getOpen()) state = " CLOSED ";
        
        return getBreakoutRoomID() + state + getNumberOfParticipants();
    }
    
    public void closeBreakoutRoom()
    {
        // put your code here
        this.participants = new Participant[this.breakoutRoomSize]; //Clears list of participants
        this.numberOfParticipants = 0;
        this.open = false;
    }
    
    public void openBreakoutRoom()
    {
        this.open = true;
    }
}
