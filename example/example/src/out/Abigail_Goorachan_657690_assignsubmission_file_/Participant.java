package out.Abigail_Goorachan_657690_assignsubmission_file_;/**
 * 816007500
 */
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
        else{
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details;
        details = "Participant: " + participantID;
        return details;
    }
    
    //https://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html#axzz6lxMD9fB0 
}
