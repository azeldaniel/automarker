package out.Brandon_Noray_657718_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (816018360 | Brandon Noray)
 * @version (v1.6.9)
 */
public class Participant
{
    /** Variables **/
    private String participantID;

    /** Constructor **/
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }

    /** Methods **/
    public static boolean verifyID(String participantID)
    {
        char[] ch = participantID.toCharArray();
        boolean isDigits = true;
        for(int i=0; i<participantID.length(); i++){
            if(!Character.isDigit(ch[i])){
                isDigits = false;
                break;
            }
        }
        
        if(participantID != null && isDigits && participantID.length() == 8)
            return true;
        
        return false;
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        // put your code here
        return "Participant: " + this.getParticipantID();
    }
}
