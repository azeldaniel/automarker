package out.Ajay_Gunness_657698_assignsubmission_file_;public class Participant
{
    static String participantID;
    
    // Constructor
    public Participant(String participantID)
    {
        // code go here
    }
    
    // Accessor for participant ID
    public String getParticipantID()
    {
        return participantID;
    }

    public static boolean verifyID(String participantID)     // class method
    {
        // code go here
        int length = String.valueOf(participantID).length();
        if(length > 8 && participantID != null)
            return true;
        else 
            return false;
    }
    
    public String toString()
    { 
        String s = "Participant: " + participantID;
        return s;
    }
    
}
