package out.Kymberly_Byanile_657778_assignsubmission_file_;/* Student ID: 814117667 */
public class Participant
{
   private String participantID;
   
   public Participant (String participantID){
    this.participantID = participantID;
   }
   
   public String getParticipantID(){
    return participantID;
   }
   
   public String toString(){
    return "Participant: "+participantID;
   }
   
   //from 1st attempt
   public boolean verifyID(String participantID){
     int length = participantID.length(); 
     //check if id is 0 or more/less than 8
     if (participantID == null || participantID.length() != 8){
        return false;
    }
    
    // if it is not, then check each letter for being a number
     else if (participantID != null && participantID.length() == 8) {
         for (int i =0; i< length; i++){
            if ((Character.isLetter(participantID.charAt(i)) == true)){
            return false;
        }
      }
           
    }
    //if all the digits count as numbers   
    return true; 
    }
}
