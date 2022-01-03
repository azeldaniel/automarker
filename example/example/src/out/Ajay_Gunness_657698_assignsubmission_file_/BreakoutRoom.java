package out.Ajay_Gunness_657698_assignsubmission_file_;
public class BreakoutRoom
{
    String breakoutRoomID;
    private int breakoutRoomNumberCounter;      // class variable
    final int breakoutRoomSize = 10;                 // constant 
    
    Participant[] participants;
    int numberOfParticipants;
    boolean open;
    
    int count;
    
    public BreakoutRoom(String name)
    {
        numberOfParticipants = 0;
        open = false;
    }
     
    public boolean addParticipant(String participantID)
    {
        if(Participant.verifyID(participantID) && !findParticipant(participantID).equals(participantID) && numberOfParticipants < 10)
        {
            participants[numberOfParticipants].participantID = participantID;
            numberOfParticipants++;
            return true;
        }
        return false;

        
    }
    public Participant findParticipant(String participantID)
    {
        for(int x = 0; x<numberOfParticipants; x++)
        {
            if(participantID.equals(participants[x].participantID))
            {
                return participants[x];
            }
            return null;
        }
        return null;                      
    }
    
    public String listParticipants()
    {
        
        String list = breakoutRoomID + "\n";
        for(int x =0; x<numberOfParticipants; x++)
        {
            list += participants[x].participantID + " \n";   
        }
        return list;
    }
    
    
    public String toString()
    {
        return "sample";
    }
    
    public void openBreakoutRoom()
    {

        if(!open)
        {
            open = true;
        }
    }
    
    public void closeBreakoutRoom()
    {

        if(open)
        {
            open = false;

        }
    }    
    
    
}
