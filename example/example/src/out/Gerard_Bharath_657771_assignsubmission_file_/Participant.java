package out.Gerard_Bharath_657771_assignsubmission_file_;
/**
 * 
 *
 * @Gerard Bharath
 * 816020015
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
        this.participantID= participantID;
        
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public boolean verifyID(String participantID)
    {
        // put your code here
        if (participantID.length() == 8){               //https://www.javatpoint.com/java-string-length
        return true;
        } else{
            return false;       
        }
    }
    
    public String getParticipantID()
    {
        return this.participantID;    
    }
    
    public String toString()
    {
        String participantDetails= "Participant: " +participantID;
        return participantDetails;
    }
}

