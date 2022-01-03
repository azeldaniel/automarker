package out.Chantel_Lewis_657735_assignsubmission_file_;
/**
 * @author 816011391
 * @version 05/03/2021
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

    public static boolean verifyID(String participantID)
    {
        if(participantID != null && participantID.length() == 8)
        {
            //participantID = participantID;
            return true;
        }
        System.out.println("Participants require an ID. Please specify a Participant ID");
        return false;
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        String participantInfo = "Participant: " + participantID;
        return participantInfo;
    }
}
