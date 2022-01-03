package out.Deepak_Ramsubhag_657786_assignsubmission_file_; 
/**
 Deepak Ramsubhag
 816016482
 */
public class Participant
{
    private String participantID;
    
    public Participant(String participantID){
      this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID == null || participantID.length()!=8 ){
            return false;
        }
        
        for(int i = 0; i < participantID.length() ; i++){
            if(participantID.charAt(i) < '0' || participantID.charAt(i) > '9'){
                return false;
            }
        }
        
        return true;
        
     }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}

// Source: https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/