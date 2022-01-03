package out.Jason_Downie_657822_assignsubmission_file_;// 816004029

public class Participant
{
    private String participantID;
    
    public Participant(String participantID) //constructor
    {
        this.participantID = participantID;
    }
    
    public boolean verifyID(String participantID)
    {
        if (participantID.length() != 8)
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
    
    public String getParticipantID() //accessor
    {
     return participantID;   
    }
    
    public String toString() //turn information into a string
    {
        String details = "Participant: " + participantID;
        return details;
    }
}
