package out.Andrei_Guevara_657703_assignsubmission_file_;/**816022711
 * Andrei Guevara
 * OwO - O3O
**/

public class Participant
{
    
    private String participantID;
    
    
    Participant(){
        
        this.participantID = null;
        
    }
    
    
    Participant(String participantID){
        
        this.participantID = participantID;

    }
    
    
    private static boolean isNumber(String number){
     
        for (int t=0; t<number.length(); t++){
            
            if ((int)number.charAt(t) < 48 || (int)number.charAt(t) > 57)
            
                return false;
            
        }
        
        return true;
        
    }
    
    public static boolean verifyID(String participantID){
        
        if ((participantID == null || participantID.length() != 8) && !isNumber(participantID))
        
            return false;
        
        return true;
        
    }

    
    public String getParticipantID(){
        return this.participantID;
    }
    
    
    public String toString(){
        return ("Participant: " + this.participantID);
    }
    
    
    public void setParticipantID(String participantID){
        
        this.participantID = participantID;
        
    }
    
}
    
    
    
   