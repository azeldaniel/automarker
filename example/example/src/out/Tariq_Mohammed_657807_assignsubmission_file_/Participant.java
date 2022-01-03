package out.Tariq_Mohammed_657807_assignsubmission_file_;
/*
 Student ID: 816015043
 Name: Tariq Azard Mohammed
 Participant Class
 */

public class Participant
{
    // instance variables
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
      this.participantID = participantID;  
    }

    public String getParticipantID(){
        return participantID;
    }
    
    // class method
    public static boolean verifyID(String participantID){
        
        if(participantID == null){
            return false;
        }
        
        if(participantID.length() != 8){
            return false;
        }
        
        for(int i=0; i<participantID.length(); i++){
            /* if the character at any location 'i' in the string, is not a digit,  
             then the participantID is not valid (return false). */
             
            if(!Character.isDigit(participantID.charAt(i)))
                return false;
        }
        
        return true;
    }
    
    public String toString(){
        String ID = getParticipantID();
        
        return ("Participant: " + ID);
    }
}
