package out.Alexis_Pitypaul_657694_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Alexis Pitypaul - 816020068)
 * @version (1)
 */
public class Participant
{
   private String participantID;
    
   public Participant(String participantID){
        this.participantID = participantID;
   }
   //https://www.programiz.com/java-programming/examples/check-string-numeric
   public boolean verifyID(String participantID){
       boolean isValid = true;
       
       try{ 
            int ID = Integer.parseInt(participantID);
       } catch (NumberFormatException e){
            isValid = false;
       }
       
       if(!isValid){
           return false; //ID is invalid
       }else if(participantID.length() == 8){
           return true; //ID consists of only numbers and 8 digits
       } else{
           return false;//ID consists of only numbers but not 8 digits
       }
   }
   public String getParticipantID(){
        return participantID;
   }
   public String toString(){
        String output = "Participant: " + participantID;
        return output;
   }
}
