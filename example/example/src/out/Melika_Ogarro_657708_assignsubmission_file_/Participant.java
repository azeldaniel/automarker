package out.Melika_Ogarro_657708_assignsubmission_file_;
/**
 *
 * @authorID (816002233)
 * @version (13.02.2021)
 */
public class Participant
{
   private String participantID;
    
   public Participant(String participantID){
       this.participantID = participantID;
   }

   public static boolean verifyID(String participantID){
       if(participantID != null){
           int idLength=participantID.length();
           if(idLength!=8)
                return false;
           else{
             
               for (int i=0; i<idLength; i++){
                   if(participantID.charAt(i) < 48 || participantID.charAt(i) > 57){
                       return false;
                    }
                }
                return true;
           }
       }
       return false;
   }
   
   public String getParticipantID(){
       return participantID;
   }
    
   public String toString(){
       String state = "Participant: " + getParticipantID();
       return state;

   }
   
    
    
}
