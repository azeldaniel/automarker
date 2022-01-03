package out.Karsten_Lange_657828_assignsubmission_file_;   public class Participant{
    private String participantID;
   //ID:816014018
    
    //Constructor
    public Participant(String participantID){
        this.participantID = participantID;
        
    }
    
    
    // verifies ID of participant
   public  boolean verifyID(String participantID){
        String minLength = "00000000";
        String maxLength = "99999999";
        if((participantID.length()< minLength.length()) || (participantID.length() >maxLength.length())){                   
            return false;
        }
        else{
            return true;
        }
        
        
        
    }
    
    //Accessor For participantID Attribute
    public String getParticipantID(){
        if (verifyID(participantID) == true){
            return participantID;
        }
        else{
            return "Participant ID was not valid...";
        }
    }
    
    public String toString(){
        String details = "Participant: " + getParticipantID();
        return details;
    }
}