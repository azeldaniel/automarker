package out.Jamal_Ali_657686_assignsubmission_file_;
/**
 * Particpant Class
 * The Participant class models a participant in the virtual meeting system
 * Jamal Ali
 * ID: 816014616
 */
public class Participant
{
    // instance variables 
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }

    /**
     * Methods for Participant Class
     */
    public static boolean verifyID(String participantID)
    {
        int len = participantID.length();
        if(len == 8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID + "\n";
    }
}
