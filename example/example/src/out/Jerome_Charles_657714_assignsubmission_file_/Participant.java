package out.Jerome_Charles_657714_assignsubmission_file_;/*
Jerome Charles 816021939
Assignment 1
 */

public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    Participant(String participantID){
        this.participantID=participantID;
    }

    
    public static boolean verifyID(String participantID)
    {
        int count=participantID.length();
        boolean checker=false;
        if (count!=8){return false;}
        for (int i = 0; i < count; i++) { 
  
           
            if (participantID.charAt(i) >= '0'
                && participantID.charAt(i) <= '9') { 
                checker= true; 
            } 
            else { 
                return false; 
            } 
        } 
        return checker; 
        
    }
    
    
    public String getParticipantID(){
    return participantID;
    }
    
    
    public String toString(){
        String message=("Participant:"+ participantID);
    return message;
    }
}
