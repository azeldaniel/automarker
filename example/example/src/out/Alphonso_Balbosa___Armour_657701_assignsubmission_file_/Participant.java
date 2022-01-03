package out.Alphonso_Balbosa___Armour_657701_assignsubmission_file_;//STUDENT I.D. == 816018750
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
    private String participant_name;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        this.participantID = participantID;// initialise instance variables
    }
    
    public static boolean verifyID(String participantID)
    {
        int length = participantID.length();
            if (participantID == null){
                return false;
            }
            if (length > 8 || length < 8){
                return false;
            }
            for(int x=0; x<8; x++)
            {
                char letter = participantID.charAt(x);
                if (!(letter >= '0' && letter <= '9')){
                    return false;
                }   
            }
        return true;
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString(){
        String participant = "Participant: " + participantID;
        return participant;
    }
}
