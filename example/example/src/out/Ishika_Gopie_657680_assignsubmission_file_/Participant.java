package out.Ishika_Gopie_657680_assignsubmission_file_;/**
 * StudentID: 816018253
 */
public class Participant{
    private String participantID;

    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if ((participantID.length() == 8) && (participantID != null )){
            return true;
        }
        else{
            return false;
        }
    }
        
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String str = "";
        str = str + "Participant: " + participantID;
        return str;
    }
   
}
