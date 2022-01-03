package out.Cleopatra_Arrindell___Walker_657673_assignsubmission_file_;
/**
 * @author (813001054)
 */
public class Participant
{
   private String participantID;
   
   public Participant(String participantID){
       this.participantID = participantID;
    
    }
   
   public static boolean verifyID(String participantID){
      try {  
       Integer.parseInt(participantID);  
       
       if(participantID.matches("([0-9]{8})"))
          return true;
     } catch(NumberFormatException e){  
       return false;  
    }  
    return false;
}
    
    
   
   public String getParticipantID(){
       if(!verifyID(this.participantID)){
       return null;
      }else{
        return this.participantID;
    }
      
    }
   
   public String toString(){
       String details = " ";
       details += "Participant: " + this.participantID;
       return details;
    
    }


}
