package out.Syela_Sandy_657817_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @Student ID: 816020390
 * @version (a version number or a date)
 */
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID){
        
         this.participantID = participantID;
        
    }
    
    public static boolean verifyID(String participantID){
         if(participantID == null){
            return false;
         }
         else if(participantID.length() == 8){
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
       String s = "Participant: "+ participantID;
       return s;
     }
    
    
}
