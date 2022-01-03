package out.Shania_Harold_657840_assignsubmission_file_;// 816006213

public class Participant{
    private String participantID = ""; // 8 digit format

    public Participant(String participantID){
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){ // checks for 8 digits
        if (participantID.length() == 8){
            return true;
        } else {
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public void setParticipantID(String participantID){
        this.participantID = participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
