package out.Chad_Bhagwandeen_657831_assignsubmission_file_;
//Student ID :816002273
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants=new Participant[10];

    public BreakoutRoom(String name)
    {
        this.breakoutRoomID=name;
        breakoutRoomSize=10;
        numberOfParticipants=0;
   
        
    }
    public boolean addParticipant(String participantID)
    {
        int length=String.valueOf(participantID).length();
        if(length<8||length>8)
        {
            return false;
        }
        else if(numberOfParticipants>breakoutRoomSize)
        {
            return false;
        }
        
          participants[numberOfParticipants]= new Participant(participantID);
          numberOfParticipants++;
          return true;
    }
    public Participant findParticipant(String participantID)
    {
        if(open==false)
        {
            return null;
        }
        else
        {
            int x;
            for(x=0;x<=numberOfParticipants;x++)
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
        String list="Breakout Room ID: "+breakoutRoomID;
        list+="Participants: ";
        int x;
        for(x=0;x<=numberOfParticipants;x++)
        {
            list+="Participant ID: " +participants[x].getParticipantID();
        }
        return list;
    }
    public String toString()
    {
        String details="Breakout Room: "+breakoutRoomID;
        details+="Hosting "+numberOfParticipants+ " participants";
        if(open==true)
        {
            details+=" and is currently open";
        }
        else if (open==false)
        {
            details+=" and is currently closed";
        }
        
        return details;
        
    }
    public void closeBreakoutRoom()
    {
        open=false;
        int x;
        for(x=0;x<=numberOfParticipants;x++)
        {
            participants[x]=null; 
        }
        numberOfParticipants=0;
    }
    public void openBreakoutRoom()
    {
        open=true;
    }
    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }
    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }
    public boolean getOpen()
    {
        return open;
    }

  
}
