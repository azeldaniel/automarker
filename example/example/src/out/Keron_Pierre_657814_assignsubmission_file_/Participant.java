package out.Keron_Pierre_657814_assignsubmission_file_;//816022340
public class Participant
{
    private String participantID;
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID.length() == 8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String str = "Participant: " + participantID;
        return str;
    }
}
