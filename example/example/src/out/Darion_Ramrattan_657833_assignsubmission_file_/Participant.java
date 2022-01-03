package out.Darion_Ramrattan_657833_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Darion Ramrattan)
 * @version (a version number or a date)
 */
public class Participant
{
    private String participantID;

  
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID= participantID; 
    }
    
    public static boolean verifyID(String participantID){
        if (participantID.length() == 8 && participantID != null){
        return true; 
    }
    else 
    return false; 
    }    
    
    public String getParticipantID(){
        return participantID; 
    } 
    
    public String toString(){ 
        String details=""; 
        
        details+= "Participant: " + participantID ; 
        
       return details;  
    } 
    




}   
