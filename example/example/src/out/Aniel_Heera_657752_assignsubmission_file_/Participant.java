package out.Aniel_Heera_657752_assignsubmission_file_;//ID:816004672
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
        participantID = null;
    }
    
    public boolean verifyID(String participantID)
    {
        if(participantID.length() == 8){
            return true;
        }else{
            return false;
        }
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        String particip = "Participant: " + participantID;
        return particip;
    }
}
