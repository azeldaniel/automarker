package out.Gerard_Bharath_657771_assignsubmission_file_;
/**
 * 
 *
 * @Gerard Bharath
 * 816020015
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    public String breakoutRoomID;
    private static int breakoutRoomNumberCounter= 1;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID= name +breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        this.breakoutRoomSize= 10;
        this.participants= new Participant[10];
        this.numberOfParticipants= 0;
        this.open= true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
    
    
    public boolean addParticipant(String participantID)
    {
        Participant p= new Participant(participantID);
        boolean par;
        par= p.verifyID(participantID);
        if(numberOfParticipants== 10)
        {
            return false;
        }
        
        if((this.open== true)&& (par== true))
        {
            this.participants[numberOfParticipants]= p;
            this.numberOfParticipants++;
            return true;
        }
        return false;
    }
    

    public Participant findParticipant(String participantID)
    {
        boolean findID;
        Participant pFind= new Participant(participantID);
        findID= pFind.verifyID(participantID);
        if(findID== true){
            for(int i= 0; i< this.numberOfParticipants; i++){
                if (this.participants[i].getParticipantID().equals(participantID)){
                    return this.participants[i];
                }
            }
        }
        return null;
    }

    
    public String listParticipants()
    {
        String details= "Breakout Room ID: " +this.breakoutRoomID +"\n";
        details += "Participants: " +"\n";
        for (int i= 0; i< this.numberOfParticipants; i++){
            details += " " +this.participants[i].getParticipantID() +"\n";
        }
        return details;    
    }
    
    public String toString()
    {
        String details= breakoutRoomID +open +numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom()
    {
        this.open= false;
        this.participants= null;
        this.numberOfParticipants= 0;
        this.breakoutRoomSize= 0;            
    }
    
    public void openBreakoutRoom()
    {
        this.open= true;
    }
    

    
    
}
    
