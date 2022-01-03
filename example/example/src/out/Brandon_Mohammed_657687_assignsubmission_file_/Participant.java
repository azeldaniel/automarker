package out.Brandon_Mohammed_657687_assignsubmission_file_;//816018582
public class Participant
{
    private String participantID;
    
    public Participant(){
        
    }
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID.length()==8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public void setParticipantID(String participantID){
        this.participantID = participantID;
    }
    
    public String toString(){
        return "ParticipantID = " + getParticipantID();
    }
}
