package out.Khaalis_Delas_657745_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Khaalis De Las- 8160071114)
 * @version (a version number or a date)
 */
//Khaalis De Las- 8160071114
public class Participant 
{
   private String participantID;
   //private boolean verifyID;
   
   
   //constructor
   public Participant(String participantID){
     this.participantID= participantID;
    }
    
    //might need to add digit check
    public static boolean verifyID (String participantID){
    if (participantID == null){
    return false;
     }
    else {
        String numChecker= participantID;
        int length= numChecker.length();
        
    if (length > 8 || length < 8 ){
    return false;}
    }
    
   
    return true;

    }
    
    //accessor
    public String getParticipantID(){
    return participantID;
    }
    
    //toString
    public String toString(){
    String details= "Participant: " + participantID;
    return details;
    }
    
    
}
