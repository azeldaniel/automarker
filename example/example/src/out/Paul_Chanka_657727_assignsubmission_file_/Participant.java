package out.Paul_Chanka_657727_assignsubmission_file_;/** 816019453 */
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

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }

    /**
     *Class method that validates that a non-null,
     *participantID conforms to the required 8 digit
     *format and returns true, otherwise false. 
     */
    public boolean verifyID (String participantID)
    {
        // put your code here
        if (participantID.length() != 8){
        return false;
    }
    else{
            return true;
        }
    } 
   
    /**
     * Accessor for a participant’s ID.
     */
    public String getparticipantID(){
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
   
    
        
