package out.Carson_White_657742_assignsubmission_file_;//816020150
public class Participant
{
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID.length() == 8){
            return true;
        }else{
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    } 
    
    public String toString(){
        String output = "Participant: "+ participantID;
        return output;
    }
}
