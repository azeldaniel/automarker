package out.Adrienne_Baptiste_657672_assignsubmission_file_;
/**
 ID:816020784
 */
public class Participant 
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String participantID){
        if(verifyID(participantID)==true)
            this.participantID=participantID;
        else
            this.participantID=null;
    }
    
    public static boolean verifyID(String participantID){
        // put your code here
        if(participantID==null || participantID.length()!= 8)
            return false;
        return true;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
