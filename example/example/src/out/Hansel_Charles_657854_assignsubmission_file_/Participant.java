package out.Hansel_Charles_657854_assignsubmission_file_;
/*
 * HANSEL CHARLES
 * ID: 816011166
 */
public class Participant
{
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
        
    }
    
    public static boolean verifyID(String participantID){
        int len = participantID.length();
        
        if (participantID == null){
            return false;
        }
        else if(len !=0 && len ==8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details = "participant_" + participantID;
        
        return details;
    }
    
}
