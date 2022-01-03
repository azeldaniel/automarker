package out.Satash_Rampersad_657829_assignsubmission_file_;
/**
 * 816020134
 */
public class Participant{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if (participantID == null){
            return false;
        }
        
        if (participantID.length() == 8){
            for(int i = 0; i < participantID.length(); i++){
                if(Character.isDigit(participantID.charAt(i))){
                    return true;
                }
            }
        }
  
        return false;
    }

    public String getParticipantID( ){
        return participantID;
    }
    
    public String toString(){
        String details = "Participant: "+ participantID; 
        return details;     
    }
}
