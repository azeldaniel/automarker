package out.Selena_Ali_657815_assignsubmission_file_;// 816017254
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
        this.participantID = null;
    }

    public static boolean verifyID (String participantID){
        if (participantID.length() != 8)
            return false;
        
        return true;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participant = "Participant: " + participantID;
        return participant;
    }
}
