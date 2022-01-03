package out.Nickal_Winter_657706_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    private static boolean verifyID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
        verifyID = false;
       
    }

    
    
    public String getParticipantID(){
        return participantID;
    }
    
    
    
    public static boolean verifyID(String participantID){
        if (participantID.length() == 8 && (!participantID.equals(null))){
        verifyID = true;
        return true;
    }else{
        return false;
    }

}

   public String toString(){
       String details = "Participant: "+ participantID + "\n";
       return details;
    }
}
