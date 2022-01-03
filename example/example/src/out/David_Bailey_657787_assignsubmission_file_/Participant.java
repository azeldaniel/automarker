package out.David_Bailey_657787_assignsubmission_file_;public class Participant{
    private String participantID;
    
    public Participant(String participantID) {
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){// i assumed based on the data that ALL char are digits and did not provide checks using ASCII to eliminate non-digits.
        if (participantID != null && participantID.length() == 8){ // if ID is null or has more or less than 8 digits ID is invalid
            return true;
        }
        return false;
    
    }
    
    public String getParticipantID() {
        return participantID;
    }
    
    public String toString() { 
        String details ="Participant: ";
        details  += participantID;
        return details;
    }
}
