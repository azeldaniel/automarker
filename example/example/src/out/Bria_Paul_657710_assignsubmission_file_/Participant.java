package out.Bria_Paul_657710_assignsubmission_file_;
/**
 * @author: Bria Paul 
 * 816018930
 * @version 29/01/2021
 */

public class Participant{
    // instance variable
    private String participantID;

    //Constructor for objects of class Participant
    public Participant(){
        participantID="00000000";
    }
    
    public Participant (String participantID) {
        this.participantID=participantID;
    }
    
    /*** Class method that validates that a non-null, participantID conforms to the required 8 digit
    format and returns true, otherwise false. */
    
    public static boolean verifyID(String participantID){
        int length = String.valueOf(participantID).length();
        
        if((participantID.equals(null)) || (length != 8)){
            return false;
        }
        
        return true; //participant ID conforms to 8 digits and isn't null
    }
    
    /** Accessor for a participant’s ID */
    public String getParticipantID(){
        return participantID;
    }
    
    /*** Returns a String representation of the state of a Participant formatted as follows:
         Participant: participantID */
  
    public String toString(){
        String detail = "";
        
        if(verifyID(participantID)==true){
          detail = "Participant: " + participantID;
          return detail;
    }
    else{
         detail = "Participant ID is invalid";
         return detail;
    }
    }
 
}