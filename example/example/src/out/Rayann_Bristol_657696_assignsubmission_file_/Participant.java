package out.Rayann_Bristol_657696_assignsubmission_file_;
/**
 * Rayann Bristol
 * 816013958
 */
public class Participant
{
    private String participantID;

     Participant(String participantID)
    {
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID)
    {
       String i = participantID;
        if(i.length() == 8){
           return true;
       } else{
           return false;
       }
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        String details = " ";
        
        
        details += "Participant: "+participantID;
        //details += "  Length: " +i.length();
        //details += "  Verified: " +verifyID(participantID);
        return details;
    }
}
