package out.Johnathan_Girod___Williams_671779_assignsubmission_file_;
/**
 
 
 * Johnathan Girod-Williams 816004809
 * Feb 15th 2021
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
     private String breakoutRoomID;
     private static int breakoutRoomNumberCounter;
     private final int breakoutRoomSize;
     private Participant[] participants;
     private int numberOfParticipants;
     private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name;
        this.breakoutRoomNumberCounter = Character.getNumericValue(name.charAt(name.length() -1));
        this.breakoutRoomSize = 10;
        this.participants = new Participant[10];
        this.numberOfParticipants = 0;
        this.open = true;
    }

    public boolean addParticipant(String participantID)
    {
        Participant p = new Participant("22446688");
        
        if(participantID.length() != 8)
        {
            System.out.println( "participantID ' " + participantID + " ' not correct length." );
            return false;
        }
        
        if(this.numberOfParticipants<10)
        {
            this.participants[this.numberOfParticipants] = new Participant(participantID);
            this.numberOfParticipants++;
            return true;
        }
        
        
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        
        
        for(int i = 0; i < this.numberOfParticipants ; i++)
        {
            
            
            if(this.participants[i].verifyID(participantID))
            {
                return this.participants[i];
            }
        }
        
        
        return null;
    }
    
    public String listParticipants()
    {
        String s = "";
        
        for(int i = 0; i < this.numberOfParticipants ; i++)
        {
            s += this.participants[i].getParticipantID() + " ";
        }
        
        return s;
    }
    
    public String toString()
    {
        String s = "";
        
        return s + this.breakoutRoomID + " " + this.breakoutRoomNumberCounter + " " + this.breakoutRoomSize + " Number of participants:" + this.numberOfParticipants + " open:" + this.open;
    }
    
    public void closeBreakoutRoom()
    {
        this.open = false;
    }
    
    public void openBreakoutRoom()
    {
        this.open = true;
    }
    
    public boolean getOpen()
    {
        return this.open;
    }
    
    public String getBreakoutRoomID()
    {
        return this.breakoutRoomID;
    }
}
