package out.Jean___Paul_Lezama_657809_assignsubmission_file_;
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
        if(participantID.contains("[0-9]+") && (participantID.length() == 8 )){
            return true;
        }
        else
            return false;
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String output = "Participant: "+participantID;
        return output;
    }
}
