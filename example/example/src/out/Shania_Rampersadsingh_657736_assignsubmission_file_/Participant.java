package out.Shania_Rampersadsingh_657736_assignsubmission_file_;
/**
 * Description: The Participant class models a participant
 * in the virtual meeting system
 * 
 * @author Shania Rampersadsingh
 * @version 6/2/2021
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
     * verifyID(String participantID
     * Class method that validates that a non-null,
     * participantID conforms to the required 8 digit
     * format and returns true, otherwise false.
     */
    public static boolean verifyID(String participantID)
    {
        
        if (participantID.length()==8) {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Accessor for a participant’s ID
     */
    public String getParticipantID(){
        return participantID;
    }
    
    /**
     * Returns a String representation of the state of a
     * Participant formatted as follows:
     * Participant: participantID
     */
    public String toString(){
        return "Participant: " + participantID;
    }
}
