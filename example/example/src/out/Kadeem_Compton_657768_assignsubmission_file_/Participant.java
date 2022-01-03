package out.Kadeem_Compton_657768_assignsubmission_file_;//814002641

public class Participant
{
    private String participantID;


    public Participant(String participantID)
    {
        if (verifyID(participantID))
            this.participantID = participantID;
    }

    
    public static boolean verifyID(String participantID) 
    {
        if (participantID == null){
            System.out.println ("ID is null");
            return false;
        }
       
        if (participantID.length() == 8 )
            return true;
        
        else 
            return false;
        
    }

    
    public String getParticipantID( )
    {
        return participantID;
    }

    public String toString()
    {
        return participantID;
    }
    
}
