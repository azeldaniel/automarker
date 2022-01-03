package out.Amirah_Ali_657679_assignsubmission_file_;//816020184
public class Participant{
    // instance variables - replace the example below with your own
    private String participantID;

    // Constructor
   public Participant (String participantID){
        this.participantID = participantID;
    }
   
   // Check
   public static boolean verifyID (String participantID){
       if ((participantID.isEmpty()) || (participantID.length() < 8)){
           return false;
       }
        
        else{
            return true;
        }
   }
   
   // Accessor
   public String getParticipantID(){
       return this.participantID;
   }
   
   @Override
   public String toString(){
       String details = "Participant: " + this.participantID;;
       return details;
   }
}
