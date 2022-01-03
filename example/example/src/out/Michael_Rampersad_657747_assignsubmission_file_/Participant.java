package out.Michael_Rampersad_657747_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant
{
    private String participantID = null;

    //Constructor for objects of class Participant
    public Participant(String participantID)
    {
       this.participantID = participantID;
    }

    //Methods
    public static boolean verifyID (String participantID)
        {
        int count = 0;
        for(int i = 0; i < participantID.length(); i++) {    
            if(participantID.charAt(i) != ' ')    
                count++;    
        } 
        if(count == 8){
            System.out.println("Verified");
            return true;
         }else{ 
             System.out.println("Not Verified");
             return false;
            }
    }
    
    //Accessor
     public String getParticipantID(){
      return participantID; 
    }
    
    
      public String toString(){
      String details = "Participant: " + participantID;
       return details;
    }
    
    
  
   
}
