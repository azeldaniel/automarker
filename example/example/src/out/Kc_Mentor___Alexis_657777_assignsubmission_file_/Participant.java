package out.Kc_Mentor___Alexis_657777_assignsubmission_file_;//816018833
public class Participant{
    
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
       this.participantID = participantID;
    }

    public static boolean verifyID(String participantID)
    {
        if(!participantID.equals(null)){
            if(participantID.length() == 8){
                return true;
            }
            return false;
        }
        return false;      
    }
    
    public String getParticipantID (){
        return participantID;
    }
    
    public String toString(){
        return ("Participant: " + participantID);
    }
}
    
 
