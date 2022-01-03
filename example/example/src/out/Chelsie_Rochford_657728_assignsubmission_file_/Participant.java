package out.Chelsie_Rochford_657728_assignsubmission_file_;/**
 *816000366
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
        if (verifyID(participantID)) this.participantID = participantID;
        else this.participantID = null;
         
          
    }
    
    public static boolean verifyID(String participantID){
        if (participantID.length()==8)
            return true;
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participants = "Participant: " + participantID;
        return participants;
    }
}
