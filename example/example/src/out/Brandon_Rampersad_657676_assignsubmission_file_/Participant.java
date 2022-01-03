package out.Brandon_Rampersad_657676_assignsubmission_file_;
/**
 * Participant Class
 *
 * @author 816019037
 * 
 */
public class Participant 
{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID; 
    }
    
    public boolean verifyID (String participantID){
        boolean valid = true;
        
        int len = participantID.length();
        if (len != 8){
            valid = false;
        }
        return valid;
    }
    
    public String getparticipantID (){
        return participantID;
    }
        
    public String toString(){
        return "Participant :" + participantID;
    }
        

 
}
