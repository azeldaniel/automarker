package out.Jonathan_Charles_657850_assignsubmission_file_;/*816020890*/
public class Participant{
    private String participantID;
    private static int maxlen = 8;
    
    public String getParticipantID(){
        return participantID;
    }
    public Participant(String participantID){
        this.participantID = participantID;
        
    }
    public String toString(){
        String details = "Particiapant" + participantID;
        return details;
    }
    public static boolean verifyID(String participantID){
        if((!participantID.equals(null))&&(participantID.length()>maxlen)){
         return true;
        } return false;
    }
    
}