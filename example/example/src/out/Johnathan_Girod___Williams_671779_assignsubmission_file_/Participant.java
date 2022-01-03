package out.Johnathan_Girod___Williams_671779_assignsubmission_file_;
/**
 
 
 * Johnathan Girod-Williams 816004809
 * Feb 15th 2021
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
        this.participantID = participantID;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static boolean verifyID(String participantID)
    {
        
        if(participantID.length() == 8)
        {
            
            return true;
        }
        
        return false;
        
    }
    
    public String getParticipantID()
    {
        return this.participantID;
    }
    
    public String toString()
    {
        return "Participant: " + this.participantID;
    }
    
    
}
