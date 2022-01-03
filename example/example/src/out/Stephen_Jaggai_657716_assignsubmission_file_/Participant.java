package out.Stephen_Jaggai_657716_assignsubmission_file_;// 816019082

public class Participant{
    public String participantID;
    
    public Participant (String participantID){
        this.participantID= participantID;
    }
    
    public boolean verifyID(String participantID){
        int length = String.valueOf(participantID).length();
        if (length==8 && participantID != null){
            return true;
        }
        return false;
    }
    
    public String getParticipantID( ){
        return participantID;
    }
    
    public String toString( ){
        String a = "Participant: " + participantID;
        return a;
    }
}