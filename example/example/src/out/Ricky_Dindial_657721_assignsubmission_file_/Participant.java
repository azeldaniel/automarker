package out.Ricky_Dindial_657721_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * Ricky Dindial
 * 816022023
 */
public class Participant
{
    private String participantID;
    
    // Constructor
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }
    
    
    // Accessor
    public String getParticipantID(){
        return this.participantID;
    }
    
    
    public static boolean verifyID(String participantID){
        int lengthOfID;
        lengthOfID = participantID.length();
        if(lengthOfID == 8){
            return true;
        }
        return false;
    }
    
    
    public String toString(){
        String participant = "Participant: " + participantID;
        return participant;
    }
  
}
