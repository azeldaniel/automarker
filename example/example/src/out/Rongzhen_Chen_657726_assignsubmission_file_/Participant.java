package out.Rongzhen_Chen_657726_assignsubmission_file_;//816014227
public class Participant{
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if((participantID.length()==8)){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
