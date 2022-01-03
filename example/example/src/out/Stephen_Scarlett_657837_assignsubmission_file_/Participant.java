package out.Stephen_Scarlett_657837_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Stephen Scarlett, 816013791)
 * @version (a version number or a date)
 */
public class Participant
{
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }

    public static boolean verifiyID(String participantID){
        if(participantID.length() == 8){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participantInfo = "Participant: " + participantID;
        return participantInfo;
    }
    
}
