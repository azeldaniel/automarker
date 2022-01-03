package out.Jason_Downie_657822_assignsubmission_file_;// 816004029

public class BreakoutRoom
{
    private String breakoutRoomID;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public static int breakoutRoomSize = 10;
    public static int breakoutRoomNumberCounter = 1;
    
    public BreakoutRoom (String breakoutRoomID) //constructor
    {
        this.breakoutRoomID = breakoutRoomID; //gets name of breakout room and concatanates a unique number to it
        this.numberOfParticipants = 0;
        this.breakoutRoomNumberCounter++;
        this.participants = new Participant[breakoutRoomSize];
        this.open = false;
    }
    
    public String getBreakoutRoomID() //accessor
    { 
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants() //accessor
    {
        return this.numberOfParticipants;
    }
    
    public boolean getOpen() //accessor
    {
        return this.open; 
    }
       
    public  void closeBreakoutRoom() 
    {
        for(int i=0; i< this.numberOfParticipants; i++)
        {
            this.participants[numberOfParticipants]=null;
        }
        this.numberOfParticipants=0;
        this.open = false;
    }
    
    public void openBreakoutRoom()
    {
        this.open = true;
    }
    
    public boolean addParticipant( String participantID)
    {
        if(findParticipant(participantID)!= null)
        {
            return false;
        }        
        else if(numberOfParticipants <10)
        {
            this.participants[numberOfParticipants++]= new Participant(participantID);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public Participant findParticipant( String participantID)
    {
        for (int i =0; i < this.numberOfParticipants; i++)
        {
            if(this.participants[i].getParticipantID() == participantID)
            return this.participants[i];
        }
        
        return null;
    }
    
    public String toString() 
    {       
       if (this.open) 
          return breakoutRoomID +" OPEN "+numberOfParticipants;
       else
          return breakoutRoomID +" CLOSED "+numberOfParticipants;      
    }
    
    public String listParticipants() 
    {
        String details = this.breakoutRoomID;
        for (int i = 0;i< numberOfParticipants;i++)
        {
            details+= "/n "+this.participants[i];
        }
        return details;
    }
    /*
    
    
    
    
    
    
    
    
    
    */

    
}
