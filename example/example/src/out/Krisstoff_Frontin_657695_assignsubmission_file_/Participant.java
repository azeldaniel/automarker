package out.Krisstoff_Frontin_657695_assignsubmission_file_;
/**
 * Krisstoff Frontin
 * 816001130
 * 
 * 
 */
public class Participant
{
    
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        
        participantID = participantID; 
    }

    
    public boolean verifyID(String participantID)
    {
        int length;
        length = participantID.length();
        if(length == 8){
            return true;
        }
        return false; 
    }
    public String getParticipantID()
    {
        return participantID;
        
    }
    public String toString()
    {
        String s;
        s = "Participant: " + participantID ;
        return s; 
        
    }
}
