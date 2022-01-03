package out.Narin_Ramnehal_657843_assignsubmission_file_;// ID - 816015907

public class Participant
{
    private String participantID;
    private static int compare;
    
    // Constructor
    public Participant(String participantID)
    {
        this.participantID = participantID;
    } 
    
    // Accessors
    public String getParticipantID()
    {
        return participantID;
    }
    
    // Methods
    public static boolean verifyID(String participantID)
    {
        compare = participantID.compareTo("99999999");
        if (participantID != null && compare <= 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public String toString()
    {
        String details = "Participant: ";
        details += participantID;
        return details;
    }
    
}
