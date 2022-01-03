package out.Sadiyya_Ali_657734_assignsubmission_file_;//816013697
public class Participant {
    private String participantID;
    
    public Participant (String participantID) {
        this.participantID = participantID;
    }
    
    public boolean verifyID (String participant) {
        int format = participant.length();
        
        if (format == 8) {
            return true;
        }
        
        else {
            return false;
        }
    }
    
    public String getParticipantID() {
        return participantID;
    }
    
    public String toString() {
        String participantDetails = "Participant: " +participantID;
        return participantDetails;
    }
}
