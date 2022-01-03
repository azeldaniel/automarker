package out.Brandon_Bharath_657792_assignsubmission_file_;//816020909 Brandon Bharath
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name)
    {
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    public boolean addParticipant(String participantID)
    {
       if(this.open == true)
       {
           Participant p1 = new Participant(participantID);
           if(p1.verifyID(participantID) == false)
           {
               System.out.println("ID not valid.");
               return false;
           }
           else if(this.numberOfParticipants < this.breakoutRoomSize) 
           {
               this.participants[numberOfParticipants] = new Participant(participantID);
               this.numberOfParticipants++;
               return true;
           }
           else
           {
               System.out.println(this.breakoutRoomID + " is full, cannot add participant.");
               return false;
           }
       }
       System.out.println("Breakout Room is closed, cannot add participant.");
       return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        if(this.open == true)
        {
            Participant p1 = new Participant(participantID);
            if(p1.verifyID(participantID) == false)
            {
                return null;
            }
            for(int x = 0; x < this.numberOfParticipants; x++)
            {
                if(participants[x].getParticipantID().equals(participantID))
                {
                    return participants[x];
                }
            }
        }
        return null;
    }
    
    public String listParticipants()
    {
        String details;
        if(this.open == false)
        {
               details = this.breakoutRoomID + " is closed.\n";
               return details;
        }
        if(this.numberOfParticipants == 0)
        {
            details = this.breakoutRoomID + " has 0 participants.\n";
            return details;
        }
        details = "Breakout room ID: " + this.breakoutRoomID + "\n";
        int x = 0;
        while(x < this.numberOfParticipants)
        {
            details += this.participants[x].toString();
            details += "\n";
            x++;
        }
        return details;
    }
    
    public String toString() 
    {
        String details = this.breakoutRoomID;
        if(this.open == true)
        {
            details += " OPEN ";
        }
        else
        {
            details += " CLOSED ";
        }
        details += this.numberOfParticipants + "\n";
        return details;
    }
    
    public void closeBreakoutRoom()
    {
        this.open = false;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom()
    {
       this.open = true;
    }
    
    public String getBreakoutRoomID()  //additional accessor to return the breakoutRoomID
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
}