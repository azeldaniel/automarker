package out.Rajiv_Sadho_657769_assignsubmission_file_;
/**
 * 816022655
 */
public class Participant {
    private String participantID;

    public Participant(String participantID) {
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID) {
        if(participantID.length() != 8)
            return false;
        try {
            Integer.parseInt(participantID);
            return true;
        } catch(NumberFormatException e) {
            System.out.println(e + " (Participant ID must consist of 8 digits)");
            return false;
        } 
    }
    
    public String getParticipantID() {
        return participantID;
    }
    
    public String toString() {
        return "Participant: " + participantID;
    }
}
