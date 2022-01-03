package out.Jamie_Mahabir_657666_assignsubmission_file_;
/**
 Participant Class
 816019893
 */

public class Participant
{
    
    //state attribute
    private String participantID;
    
    //methods
    public Participant(String participantID){
        this.participantID=participantID;
    
    }
    
    public static boolean verifyID(String participantID){
        
        if(participantID!=null){
            if(participantID.length()==8){
                return true;
            }
            return false;
        }
        return false;
        
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    
    public String toString(){
        
        String details="Participant: "+ participantID;
        
        return details;
        
    }
}
