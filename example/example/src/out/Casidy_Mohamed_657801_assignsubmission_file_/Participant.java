package out.Casidy_Mohamed_657801_assignsubmission_file_;//816013169

public class Participant
{
    private String participantID;
    /** Constructor  **/
    
    public Participant()
    {
    }
    
    public Participant(String participantID)
    {
       this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID)
    {
        if(participantID==null)
            return false;
        
        if(participantID.length()!=8)
            return false;
        else 
        { 
            for(int x= 0;x< participantID.length();x++) 
            {
                if(participantID.charAt(x)< '0' && participantID.charAt(x) >'9') 
                { 
                    return false; 
                } 
            } 
        } 
        return true;
            /*   try
               {
                    Integer.parseInt(participantID);
               }
               catch (NumberFormatException nfe)
               {
                   return false;
               }
            */
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        String details="Participant: " + getParticipantID();
        return details;
    }
}    