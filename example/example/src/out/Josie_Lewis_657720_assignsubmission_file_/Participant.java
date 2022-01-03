package out.Josie_Lewis_657720_assignsubmission_file_;


/**
 * Josie Lewis 816020986
 */

public class Participant
{

    
    private String participanID; 
   
    public Participant(String participanID) {
        participanID = null;
        
    }
    
   
    public boolean verifyID(String participantID){
      
        if (participantID != null) {
            if (participantID.length()==8){
            return true;
        }
        else {
            return false;
        } }
        else {
            return false;    
   
         }
      }
   
   public String getParticipantID() {
     String n=null;
    return n;
   }
   
   public String toString() {
       String print="";
       print = "Participant: " +getParticipantID();
       return print;
    }

}
