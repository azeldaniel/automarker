package out.Casidy_Mohamed_657801_assignsubmission_file_;//816013169
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    private int brNo;
    private int x;
    private boolean v;
    private String list;
    
    public boolean getOpen()
    {
        return open;
    }
    
    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }
    
    public BreakoutRoom(String name)
    {
        numberOfParticipants=0;
        open=true;
        breakoutRoomNumberCounter=1;
        brNo=breakoutRoomNumberCounter;
        breakoutRoomID= name+ breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        breakoutRoomSize=10;
        this.participants= new Participant[breakoutRoomSize];
        
        x=0;
        v=false;
        list="";
    }
    
    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }
    
    public int getBrNo()
    {
        return brNo;
    }
    
    public boolean addParticipant(String participantID)
    {
        if(Participant.verifyID(participantID) == true)
        {
            for(x=0;x<breakoutRoomSize;x++)
            {
                if(participants[x] != null && participants[x].getParticipantID().equals(participantID))
                {
                    System.out.println("Sorry, this participant already exists");
                    return false;
                }
            }
            
            if(open==false)
            {
                System.out.println("Sorry, the room is closed");
                return false;
            }
            
            if(numberOfParticipants <= breakoutRoomSize)
            {
                participants[numberOfParticipants] = new Participant(participantID); 
                 
            }
            else
            {    
                System.out.println("Sorry, the room is full");
                return false;
            }
            numberOfParticipants++;
            return true;
        }
        System.out.println("Sorry, that is an invalid ID");
        return false;
    }

   
    public String listParticipants()
    {
        String list=" ";
        int x = 0;
        
        while(x <10 && participants[x] != null)
        {
            list += participants[x].getParticipantID() + "\n";
            x++;
        }
        return list; 
    }
    
     public Participant findParticipant(String participantID)
    {
        v=Participant.verifyID(participantID);
        
        if(v==false)
        {
            System.out.println("Sorry, invalid participant ID");
            return null; 
        }
        for(x=0;x<numberOfParticipants;x++)
         {
             if(participants[x].getParticipantID().equals(participantID))
             {
                 return participants[x];
             }
         }
        return null;
    }
    
    
    public String toString()
    {
       list="";
       list= list + breakoutRoomID + "  ";
       if(open==true)
            list= list + "OPEN";
       else
            list=list+ "CLOSED";
       return list;
    }
    
    public void closeBreakoutRoom()
    {
        open=false;
        for(x=0;x<breakoutRoomSize;x++)
        {
            participants[x]=null;
        }
        numberOfParticipants=0;
        System.out.println("Breakout Room has been closed and state is  " +open);
    }
    
    public void openBreakoutRoom()
    {
        open=true;
        
        for(x=0;x<breakoutRoomSize;x++)
        {
            Participant p=new Participant();
            participants[x]=p;
        }
        System.out.println("The Breakout Room has been opened and state is  " +open);
    }
    
        
    
}