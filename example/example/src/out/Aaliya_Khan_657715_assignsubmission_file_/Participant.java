package out.Aaliya_Khan_657715_assignsubmission_file_;
/**
 * Student ID - 816019696
 */
public class Participant
{
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID == null || participantID.length() != 8){
            return false;
        }
        try{
            int ID = Integer.parseInt(participantID);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participantDetails =  "Participant: " + participantID;
        
        return participantDetails;
    }
    
}

/* code for verifyID - https://www.baeldung.com/java-check-string-number */