package out.Isaiah_Norcisse_657783_assignsubmission_file_;// Student ID : 816016804
// COMP 2603 A1


public class BreakoutRoom  
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    protected Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
         this.numberOfParticipants=0;
         this.open=true;
         this.breakoutRoomSize=10;
         this.participants=new Participant[breakoutRoomSize];
         this.breakoutRoomID=name+breakoutRoomNumberCounter;
    }
    
    public void setBRCounter(int i)
    {
        this.breakoutRoomNumberCounter=i;
    }
    public String getBreakoutRoomID()
    {
        return this.breakoutRoomID;
    }
    public int getNumberOfParticipants()
    {
        return this.numberOfParticipants;
    }
    public int getBreakoutRoomNumberCounter()
    {
        return this.breakoutRoomNumberCounter;
        
    }
    
    
    public boolean addParticipant(String participantID)
    {
        Participant p = new Participant(participantID);
        
        if(p.verifyID(p.getParticipantID())==true && open==true && numberOfParticipants<breakoutRoomSize)
        {
            this.participants[this.numberOfParticipants]= new Participant(p.getParticipantID());
            this.numberOfParticipants++;
            return true;
        }
        
        return false;
    }
    
    public Participant findParticipant( String participantID)
    {
        Participant p = new Participant(participantID);
        
        if(p.verifyID(p.getParticipantID())==false)
            return null;
        
        else {
            for(int i=0;i<this.numberOfParticipants;i++)
            {
                if(this.participants[i].equals(p))
                {
                    return this.participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipant( )
    {
        String details=getBreakoutRoomID()+"\n";
        for(int i=0;i<this.numberOfParticipants;i++)
            details+=participants[i].toString();
            return details;
    }
    
    public  String toString()
    {  String details="";
        if(open==true)
            details=getBreakoutRoomID() + "Hosting: " + getNumberOfParticipants() + "Status: Open\n" ;
        else
           details=getBreakoutRoomID() + "Hosting: " + getNumberOfParticipants() + "Status: Close\n" ;
           return details;
          
    }
    
    public void closeBreakoutRoom()
    {
        this.open=false;
    }
    
    public void openBreakoutRoom()
    {
        this.open=true;
    }
}
